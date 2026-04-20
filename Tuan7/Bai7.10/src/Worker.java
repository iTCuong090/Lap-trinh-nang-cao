/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên hiểu:
 * 1. Vấn đề "visibility" trong đa luồng: một luồng thay đổi biến,
 *    luồng khác có thể KHÔNG thấy thay đổi đó.
 * 2. Từ khóa volatile giải quyết vấn đề visibility như thế nào.
 * 3. Cách dừng luồng an toàn bằng cờ (flag) thay vì Thread.stop() (deprecated).
 * 4. Sự khác biệt giữa volatile và synchronized.
 */
public class Worker implements Runnable {

    /*
     * [KIẾN THỨC NÂNG CAO] Từ khóa volatile
     * 
     * VẤN ĐỀ: Tại sao KHÔNG dùng volatile có thể gây lỗi?
     * - Mỗi luồng có bộ nhớ riêng (cache cục bộ) để tăng tốc.
     * - Khi luồng Worker đọc biến running, nó có thể đọc từ cache
     *   thay vì bộ nhớ chính (main memory).
     * - Khi luồng main gọi stop() → thay đổi running trong main memory.
     * - Nhưng luồng Worker vẫn đọc running = true từ cache CŨ → chạy mãi!
     * 
     * GIẢI PHÁP: volatile
     * - volatile đảm bảo mỗi lần đọc biến → đọc từ main memory (không cache).
     * - volatile đảm bảo mỗi lần ghi biến → ghi vào main memory ngay lập tức.
     * - Tất cả luồng đều "thấy" giá trị mới nhất.
     * 
     * volatile vs synchronized:
     * - volatile: chỉ đảm bảo VISIBILITY (nhìn thấy giá trị mới).
     *   KHÔNG đảm bảo atomicity (thao tác nguyên tử).
     *   Ví dụ: volatile int x; x++ vẫn có thể sai vì x++ = đọc + tăng + ghi.
     * - synchronized: đảm bảo CẢ visibility VÀ atomicity, nhưng nặng hơn.
     * 
     * Khi nào dùng volatile?
     * - Chỉ có 1 luồng GHI, nhiều luồng ĐỌC → dùng volatile là đủ.
     * - Nếu nhiều luồng cùng GHI → cần synchronized hoặc Atomic*.
     */
    private volatile boolean running = true;

    /**
     * Đặt cờ running = false để yêu cầu luồng dừng lại.
     * Đây là cách dừng luồng AN TOÀN.
     * 
     * [LƯU Ý] KHÔNG dùng Thread.stop()!
     * - Thread.stop() đã bị đánh dấu deprecated (lỗi thời) từ Java 1.2.
     * - Thread.stop() dừng luồng đột ngột → dữ liệu có thể bị hỏng.
     * - Cách đúng: dùng cờ (flag) để luồng tự kiểm tra và thoát vòng lặp.
     */
    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Worker bat dau chay...");
        int count = 0;
        while (running) {
            count++;
            System.out.println("Working... (lan " + count + ")");
            try {
                // Nghỉ 200ms giữa mỗi vòng lặp để tránh in quá nhanh
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Worker bi gian doan!");
                break;
            }
        }
        System.out.println("Worker da dung lai sau " + count + " lan.");
    }
}
