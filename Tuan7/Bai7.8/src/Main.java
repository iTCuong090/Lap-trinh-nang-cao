import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên:
 * 1. Hiểu cách xử lý đa giai đoạn (pipeline) với đa luồng.
 * 2. Sử dụng 2 thread pool riêng biệt cho 2 giai đoạn xử lý khác nhau.
 * 3. Kỹ thuật "chaining": kết quả giai đoạn 1 làm đầu vào giai đoạn 2.
 * 4. AtomicLong để cộng tổng an toàn luồng.
 * 5. Bài toán thực tế: lọc dữ liệu → tính toán trên dữ liệu đã lọc.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so mang n: ");
        int n = scanner.nextInt();

        int[][] arrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            arrays[i] = new int[size];
            for (int j = 0; j < size; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        /*
         * [KIẾN THỨC NÂNG CAO] Hai Thread Pool riêng biệt
         * - Pool 1 (stage1Pool): xử lý giai đoạn 1 - lọc số nguyên tố.
         * - Pool 2 (stage2Pool): xử lý giai đoạn 2 - tính tổng bình phương/lập phương.
         * 
         * Vì sao cần 2 pool riêng?
         * - Tách biệt trách nhiệm: mỗi pool quản lý một loại công việc.
         * - Tránh deadlock: nếu dùng chung pool, task giai đoạn 1 đợi task giai đoạn 2
         *   mà pool hết luồng → kẹt vĩnh viễn (thread starvation deadlock).
         * - Dễ điều chỉnh: có thể cho pool 1 nhiều luồng hơn nếu giai đoạn 1 nặng.
         */
        ExecutorService stage1Pool = Executors.newFixedThreadPool(n);
        ExecutorService stage2Pool = Executors.newFixedThreadPool(n);

        /*
         * [KIẾN THỨC] AtomicLong
         * - Giống AtomicInteger nhưng dùng cho kiểu long (số lớn hơn).
         * - addAndGet(value): cộng value vào giá trị hiện tại, trả về kết quả.
         * - An toàn luồng mà không cần synchronized.
         */
        AtomicLong totalSum = new AtomicLong(0);

        // ===== GIAI ĐOẠN 1: Lọc số nguyên tố =====
        // Lưu Future của giai đoạn 1 - mỗi Future chứa danh sách số nguyên tố
        List<Future<List<Integer>>> stage1Futures = new ArrayList<Future<List<Integer>>>();

        for (int i = 0; i < n; i++) {
            final int index = i;
            final int[] arr = arrays[i];

            Callable<List<Integer>> stage1Task = new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() {
                    List<Integer> primes = new ArrayList<Integer>();
                    for (int j = 0; j < arr.length; j++) {
                        if (isPrime(arr[j])) {
                            primes.add(arr[j]);
                        }
                    }
                    System.out.println("Stage 1 - Array " + index + ": " + primes);
                    return primes;
                }
            };

            stage1Futures.add(stage1Pool.submit(stage1Task));
        }

        // ===== GIAI ĐOẠN 2: Tính tổng bình phương hoặc lập phương =====
        List<Future<Long>> stage2Futures = new ArrayList<Future<Long>>();

        for (int i = 0; i < n; i++) {
            final int index = i;
            final Future<List<Integer>> stage1Future = stage1Futures.get(i);

            Callable<Long> stage2Task = new Callable<Long>() {
                @Override
                public Long call() {
                    try {
                        /*
                         * [LƯU Ý] stage1Future.get() ở đây sẽ CHẶN
                         * cho đến khi giai đoạn 1 của mảng này xong.
                         * Nhưng vì chạy trong pool 2 (riêng biệt),
                         * nên pool 1 vẫn hoạt động bình thường.
                         */
                        List<Integer> primes = stage1Future.get();
                        long sum = 0;
                        boolean isEven = (primes.size() % 2 == 0);

                        if (isEven) {
                            // Số lượng nguyên tố CHẴN → tổng bình phương
                            for (int j = 0; j < primes.size(); j++) {
                                long val = primes.get(j);
                                sum += val * val;
                            }
                            System.out.println("Stage 2 - Array " + index 
                                + ": sum of squares = " + sum);
                        } else {
                            // Số lượng nguyên tố LẺ → tổng lập phương
                            for (int j = 0; j < primes.size(); j++) {
                                long val = primes.get(j);
                                sum += val * val * val;
                            }
                            System.out.println("Stage 2 - Array " + index 
                                + ": sum of cubes = " + sum);
                        }

                        // Cộng vào tổng chung (an toàn luồng)
                        totalSum.addAndGet(sum);
                        return sum;
                    } catch (Exception e) {
                        System.out.println("Array " + index + ": Loi - " + e.getMessage());
                        return 0L;
                    }
                }
            };

            stage2Futures.add(stage2Pool.submit(stage2Task));
        }

        // Đợi tất cả giai đoạn 2 hoàn thành
        for (int i = 0; i < stage2Futures.size(); i++) {
            try {
                stage2Futures.get(i).get();
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }

        System.out.println("Total = " + totalSum.get());

        // Đóng cả 2 pool
        stage1Pool.shutdown();
        stage2Pool.shutdown();
        scanner.close();
    }

    /**
     * Kiểm tra số nguyên tố.
     * Số nguyên tố là số > 1 và chỉ chia hết cho 1 và chính nó.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
