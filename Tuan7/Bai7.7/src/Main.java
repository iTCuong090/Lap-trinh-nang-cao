import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên:
 * 1. Thực hành xử lý song song thực tế: đếm số nguyên tố trong nhiều mảng.
 * 2. Kỹ năng tổng hợp kết quả từ nhiều luồng để tìm mảng tối ưu nhất.
 * 3. Xử lý trường hợp đặc biệt: nhiều mảng cùng giá trị max → in tất cả.
 * 4. Thuật toán kiểm tra số nguyên tố cơ bản.
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

        ExecutorService executor = Executors.newFixedThreadPool(n);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

        for (int i = 0; i < n; i++) {
            final int index = i;
            final int[] arr = arrays[i];

            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() {
                    int count = 0;
                    for (int j = 0; j < arr.length; j++) {
                        if (isPrime(arr[j])) {
                            count++;
                        }
                    }
                    return count;
                }
            };

            futures.add(executor.submit(task));
        }

        // Tổng hợp kết quả: lưu số lượng nguyên tố của từng mảng
        int[] primeCounts = new int[n];
        int maxPrimes = -1;

        for (int i = 0; i < futures.size(); i++) {
            try {
                int count = futures.get(i).get();
                primeCounts[i] = count;
                System.out.println("Array " + i + ": " + count);

                if (count > maxPrimes) {
                    maxPrimes = count;
                }
            } catch (Exception e) {
                System.out.println("Array " + i + ": Loi - " + e.getMessage());
                primeCounts[i] = 0;
            }
        }

        // Tìm tất cả mảng có số nguyên tố nhiều nhất (có thể nhiều mảng cùng max)
        System.out.print("Most primes: ");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (primeCounts[i] == maxPrimes) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print("Array " + i + " with " + maxPrimes + " primes");
                first = false;
            }
        }
        System.out.println();

        executor.shutdown();
        scanner.close();
    }

    /**
     * Kiểm tra số nguyên tố.
     * 
     * [THUẬT TOÁN]
     * - Số nguyên tố là số > 1 và chỉ chia hết cho 1 và chính nó.
     * - Chỉ cần kiểm tra ước từ 2 đến căn bậc hai của n.
     *   Vì nếu n = a * b, thì ít nhất 1 trong 2 số a, b phải <= sqrt(n).
     * 
     * [LƯU Ý] i * i <= n thay vì i <= Math.sqrt(n)
     * - Tránh dùng phép tính dấu phẩy động (floating point) → chính xác hơn.
     * - Math.sqrt() trả về double, có thể gây sai số khi so sánh.
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
