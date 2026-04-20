import java.util.concurrent.locks.ReentrantLock;

/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên hiểu:
 * 1. ReentrantLock - cơ chế khóa linh hoạt hơn synchronized.
 * 2. Sự khác biệt giữa lock() (chờ vô hạn) và tryLock() (thử, không chờ).
 * 3. Kỹ năng bảo vệ dữ liệu dùng chung trong môi trường đa luồng.
 * 4. Pattern lock-try-finally: ĐẢM BẢO unlock luôn được gọi.
 */
public class Counter {
    private int value = 0;

    /*
     * [KIẾN THỨC NÂNG CAO] ReentrantLock
     * - Giống synchronized nhưng linh hoạt hơn nhiều.
     * - Ưu điểm so với synchronized:
     *   + Có thể "thử" lấy lock (tryLock) mà không cần chờ vô hạn.
     *   + Có thể chờ với giới hạn thời gian (tryLock với timeout).
     *   + Có thể interrupt luồng đang chờ lock (lockInterruptibly).
     *   + Hỗ trợ fairness (công bằng): luồng chờ lâu nhất được ưu tiên.
     * 
     * "Reentrant" nghĩa là gì?
     * - Cùng một luồng có thể gọi lock() nhiều lần mà không bị kẹt.
     * - Nhưng PHẢI gọi unlock() đúng số lần tương ứng.
     * - Ví dụ: lock() 3 lần → phải unlock() 3 lần mới thực sự giải phóng.
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * Tăng giá trị counter bằng lock() - chờ cho đến khi lấy được lock.
     */
    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            /*
             * [LƯU Ý QUAN TRỌNG] unlock() PHẢI ở trong finally
             * - Nếu code trong try ném exception mà không finally,
             *   lock sẽ không bao giờ được giải phóng → deadlock!
             * - Đây là khác biệt lớn so với synchronized (tự unlock khi ra block).
             */
            lock.unlock();
        }
    }

    /**
     * Tăng giá trị counter bằng tryLock() - thử lấy lock, không chờ nếu bận.
     * 
     * [KIẾN THỨC] tryLock() vs lock()
     * - lock(): CHẶN luồng cho đến khi lấy được lock (có thể chờ rất lâu).
     * - tryLock(): THỬ lấy lock ngay lập tức.
     *   + Nếu lock trống → lấy được, trả về true.
     *   + Nếu lock đang bận → trả về false ngay, KHÔNG chờ.
     * 
     * Khi nào dùng tryLock()?
     * - Khi muốn tránh deadlock (lấy không được thì làm việc khác).
     * - Khi có thể bỏ qua hoặc thử lại sau nếu không lấy được lock.
     */
    public boolean tryIncrement() {
        if (lock.tryLock()) {
            try {
                value++;
                return true;
            } finally {
                lock.unlock();
            }
        } else {
            // Không lấy được lock → in thông báo và bỏ qua lần này
            return false;
        }
    }

    public int getValue() {
        return value;
    }
}
