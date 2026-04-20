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
 * 1. Hiểu cách chia nhỏ công việc để xử lý song song (divide and conquer).
 * 2. Làm quen với ExecutorService - bộ quản lý thread pool.
 * 3. Hiểu Callable (có trả về kết quả) khác với Runnable (không trả về).
 * 4. Biết cách dùng Future.get() để lấy kết quả từ luồng khác.
 * 5. Biết cách shutdown ExecutorService đúng cách để tránh rò rỉ tài nguyên.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số phần tử
        System.out.print("Nhap so phan tu n: ");
        int n = scanner.nextInt();

        // Nhập mảng
        int[] arr = new int[n];
        System.out.println("Nhap " + n + " so nguyen:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Số đoạn chia (số luồng xử lý)
        int k = 4;

        /*
         * [KIẾN THỨC NÂNG CAO] ExecutorService & Thread Pool
         * - ExecutorService là một "bộ quản lý luồng" do Java cung cấp.
         * - Executors.newFixedThreadPool(k) tạo ra một pool có đúng k luồng.
         * - Thay vì tự tạo Thread bằng tay, ta giao việc cho pool quản lý.
         * 
         * Vì sao dùng thread pool thay vì tạo Thread trực tiếp?
         * - Tạo Thread mới rất tốn tài nguyên (bộ nhớ, CPU).
         * - Thread pool tái sử dụng luồng đã tạo, tiết kiệm hơn nhiều.
         * - Dễ kiểm soát số luồng chạy đồng thời (tránh quá tải hệ thống).
         */
        ExecutorService executor = Executors.newFixedThreadPool(k);

        /*
         * [KIẾN THỨC NÂNG CAO] Callable<T> vs Runnable
         * - Runnable: phương thức run() KHÔNG trả về giá trị (void).
         * - Callable<T>: phương thức call() CÓ trả về giá trị kiểu T.
         * - Khi cần lấy kết quả từ luồng, ta PHẢI dùng Callable.
         * 
         * Future<T> là "lời hứa" sẽ có kết quả trong tương lai.
         * - future.get() sẽ CHẶN (block) cho đến khi kết quả sẵn sàng.
         */
        List<Future<Long>> futures = new ArrayList<Future<Long>>();

        // Tính kích thước mỗi đoạn
        int chunkSize = n / k;
        // Phần dư khi chia không đều sẽ được gộp vào đoạn cuối
        int remainder = n % k;

        for (int i = 0; i < k; i++) {
            // Xác định vị trí bắt đầu và kết thúc cho đoạn thứ i
            int start = i * chunkSize;
            int end;
            if (i == k - 1) {
                // Đoạn cuối cùng: lấy hết phần còn lại (bao gồm phần dư)
                end = n;
            } else {
                end = start + chunkSize;
            }

            /*
             * [KIẾN THỨC NÂNG CAO] Biến cục bộ trong lambda/anonymous class
             * - Biến dùng trong anonymous class phải là "effectively final" 
             *   (không được thay đổi giá trị sau khi gán).
             * - Vì vậy ta tạo finalStart, finalEnd để "sao chép" giá trị.
             * - Nếu dùng trực tiếp 'start' và 'end', Java sẽ báo lỗi biên dịch.
             */
            final int finalStart = start;
            final int finalEnd = end;

            /*
             * Tạo một Callable - mỗi Callable tính tổng một đoạn mảng.
             * Ở đây dùng anonymous class (lớp ẩn danh) thay vì lambda
             * để dễ hiểu hơn cho người mới học.
             */
            Callable<Long> task = new Callable<Long>() {
                @Override
                public Long call() {
                    long sum = 0;
                    for (int j = finalStart; j < finalEnd; j++) {
                        sum += arr[j];
                    }
                    System.out.println("Doan [" + finalStart + ", " + finalEnd + "): tong = " + sum);
                    return sum;
                }
            };

            /*
             * submit() gửi task vào thread pool để thực thi.
             * Trả về Future<Long> - ta lưu lại để lấy kết quả sau.
             */
            Future<Long> future = executor.submit(task);
            futures.add(future);
        }

        // Lấy kết quả từ tất cả các Future và cộng lại
        long totalSum = 0;
        for (int i = 0; i < futures.size(); i++) {
            try {
                /*
                 * [LƯU Ý] future.get() sẽ CHẶN luồng hiện tại (main)
                 * cho đến khi task tương ứng hoàn thành.
                 * Nếu task ném exception, get() sẽ ném ExecutionException.
                 */
                long partialSum = futures.get(i).get();
                totalSum += partialSum;
            } catch (Exception e) {
                System.out.println("Loi khi lay ket qua: " + e.getMessage());
            }
        }

        System.out.println("Tong cua mang: " + totalSum);

        /*
         * [KIẾN THỨC QUAN TRỌNG] Đóng ExecutorService
         * - shutdown(): không nhận task mới, nhưng chờ task đang chạy hoàn thành.
         * - shutdownNow(): cố gắng dừng tất cả task ngay lập tức.
         * - PHẢI gọi shutdown() để giải phóng tài nguyên, nếu không chương trình
         *   sẽ không kết thúc vì các luồng trong pool vẫn sống.
         */
        executor.shutdown();

        scanner.close();
    }
}
