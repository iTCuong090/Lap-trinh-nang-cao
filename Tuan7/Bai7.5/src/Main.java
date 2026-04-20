import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này tổng hợp nhiều kiến thức đa luồng:
 * 1. ExecutorService + Callable/Future: xử lý đơn hàng song song.
 * 2. Đồng bộ hóa (synchronized): ghi log an toàn từ nhiều luồng.
 * 3. AtomicInteger: đếm an toàn không cần synchronized (nhẹ hơn).
 * 4. Kỹ năng thiết kế hệ thống xử lý song song thực tế.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số đơn hàng
        System.out.print("Nhap so don hang m: ");
        int m = scanner.nextInt();

        // Nhập thông tin từng đơn hàng
        String[] ids = new String[m];
        long[] processTimes = new long[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Don " + (i + 1) + " - Nhap id: ");
            ids[i] = scanner.next();
            System.out.print("Don " + (i + 1) + " - Nhap processMs: ");
            processTimes[i] = scanner.nextLong();
        }

        // Danh sách log dùng chung - cần đồng bộ khi ghi
        List<String> logs = new ArrayList<String>();

        /*
         * [KIẾN THỨC NÂNG CAO] AtomicInteger
         * - Là lớp đếm an toàn luồng (thread-safe counter).
         * - Dùng cơ chế CAS (Compare-And-Swap) ở cấp CPU, KHÔNG cần khóa.
         * - Nhanh hơn nhiều so với synchronized khi chỉ cần đếm đơn giản.
         * 
         * Vì sao không dùng int thông thường?
         * - int++ thực ra gồm 3 bước: đọc → tăng → ghi.
         * - Nếu 2 luồng cùng làm, có thể đọc cùng giá trị → mất 1 lần tăng.
         * - AtomicInteger.incrementAndGet() đảm bảo 3 bước là "nguyên tử" (atomic).
         */
        AtomicInteger successCount = new AtomicInteger(0);

        // Tạo thread pool với 4 luồng
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>();

        for (int i = 0; i < m; i++) {
            // Cần biến final để dùng trong anonymous class
            final String orderId = ids[i];
            final long processMs = processTimes[i];

            Callable<Boolean> task = new Callable<Boolean>() {
                @Override
                public Boolean call() {
                    System.out.println("Start " + orderId);
                    try {
                        Thread.sleep(processMs);
                    } catch (InterruptedException e) {
                        System.out.println("Don " + orderId + " bi gian doan!");
                    }

                    boolean success = (processMs <= 1500);
                    String status = success ? "DONE" : "FAIL";
                    String logEntry = orderId + ": " + status;

                    /*
                     * [KIẾN THỨC] synchronized block
                     * - Thay vì khóa cả phương thức (synchronized method),
                     *   ta chỉ khóa ĐOẠN CODE cần bảo vệ → hiệu năng tốt hơn.
                     * - synchronized(logs): khóa đối tượng logs.
                     * - Tất cả luồng muốn vào synchronized(logs) phải chờ nhau.
                     */
                    synchronized (logs) {
                        logs.add(logEntry);
                    }

                    if (success) {
                        // incrementAndGet(): tăng 1 và trả về giá trị mới (an toàn luồng)
                        successCount.incrementAndGet();
                    }

                    return success;
                }
            };

            futures.add(executor.submit(task));
        }

        // Đợi tất cả đơn hàng hoàn thành
        for (int i = 0; i < futures.size(); i++) {
            try {
                futures.get(i).get();
            } catch (Exception e) {
                System.out.println("Loi xu ly don hang: " + e.getMessage());
            }
        }

        // In kết quả
        System.out.println("\n===== KET QUA =====");
        System.out.println("Success = " + successCount.get());
        System.out.println("--- Danh sach log ---");
        for (int i = 0; i < logs.size(); i++) {
            System.out.println(logs.get(i));
        }

        /*
         * [KIẾN THỨC] Đóng ExecutorService đúng cách
         * - shutdown(): dừng nhận task mới, chờ task đang chạy xong.
         * - Nếu quên gọi, chương trình sẽ treo vì luồng pool vẫn sống.
         */
        executor.shutdown();
        scanner.close();
    }
}
