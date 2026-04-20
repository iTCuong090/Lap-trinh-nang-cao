public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Tạo Worker và bọc trong Thread
        Worker worker = new Worker();
        Thread workerThread = new Thread(worker);

        // Khởi chạy luồng Worker
        workerThread.start();

        /*
         * Cho Worker chạy khoảng 1 giây (1000ms).
         * Trong thời gian này, Worker sẽ in "Working..." liên tục.
         */
        System.out.println("Main: cho Worker chay 1 giay...");
        Thread.sleep(1000);

        // Gọi stop() để đặt running = false
        System.out.println("Main: yeu cau Worker dung...");
        worker.stop();

        /*
         * [KIẾN THỨC] join() - Đợi luồng Worker kết thúc
         * - Sau khi gọi stop(), Worker vẫn cần thời gian để:
         *   + Kiểm tra điều kiện while(running)
         *   + Thoát vòng lặp
         *   + Kết thúc phương thức run()
         * - join() đảm bảo main đợi Worker xong hẳn trước khi in "Hoan tat".
         */
        workerThread.join();

        System.out.println("Main: Worker da dung. Chuong trinh hoan tat.");

        /*
         * ===== THỬ NGHIỆM =====
         * Bạn có thể thử BỎ từ khóa "volatile" ở biến running trong Worker.java
         * để thấy sự khác biệt:
         * - Với volatile: Worker dừng ngay sau khi main gọi stop().
         * - Không có volatile: Worker CÓ THỂ chạy mãi (tùy JVM và CPU cache).
         *   Điều này xảy ra vì luồng Worker đọc running từ cache CŨ (= true).
         * 
         * Lưu ý: Trên một số JVM hoặc máy, lỗi có thể không xảy ra ngay,
         * vì JVM quyết định khi nào đồng bộ cache. Nhưng lỗi tiềm ẩn vẫn tồn tại
         * và có thể bùng phát bất kỳ lúc nào trong production.
         */
    }
}
