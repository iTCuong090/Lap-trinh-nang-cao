import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên hiểu:
 * 1. Khái niệm ReadWriteLock: cho phép NHIỀU luồng đọc đồng thời,
 *    nhưng chỉ MỘT luồng ghi tại một thời điểm.
 * 2. Sự khác biệt giữa synchronized (khóa toàn bộ) và ReadWriteLock
 *    (tối ưu hơn khi có nhiều thao tác đọc).
 * 3. Cách dùng lock/unlock đúng cách (luôn unlock trong finally).
 */
public class BookStore {
    // Map lưu trữ: key = tên sách, value = số lượng
    private Map<String, Integer> stock;

    /*
     * [KIẾN THỨC NÂNG CAO] ReentrantReadWriteLock
     * - Đây là cơ chế khóa hai cấp: đọc (readLock) và ghi (writeLock).
     * - readLock: nhiều luồng có thể giữ đồng thời → đọc nhanh hơn.
     * - writeLock: chỉ 1 luồng được giữ, và không ai được đọc khi đang ghi.
     * 
     * Vì sao dùng ReadWriteLock thay vì synchronized?
     * - Với synchronized, ngay cả khi chỉ đọc, các luồng cũng phải chờ nhau.
     * - ReadWriteLock cho phép đọc đồng thời → hiệu năng tốt hơn nhiều
     *   trong tình huống "đọc nhiều, ghi ít" (read-heavy workload).
     * 
     * "Reentrant" nghĩa là gì?
     * - Một luồng đã giữ lock có thể gọi lock() lần nữa mà không bị kẹt.
     * - Ví dụ: phương thức A giữ lock, gọi phương thức B cũng cần lock
     *   → B vẫn lấy được lock vì cùng luồng.
     */
    private ReentrantReadWriteLock rwLock;

    public BookStore() {
        stock = new HashMap<String, Integer>();
        rwLock = new ReentrantReadWriteLock();
    }

    /**
     * Lấy số lượng sách theo tên - dùng readLock (cho phép đọc đồng thời).
     */
    public int getStock(String title) {
        /*
         * [LƯU Ý QUAN TRỌNG] Luôn đặt unlock() trong finally
         * - Nếu code trong try ném exception mà không có finally,
         *   lock sẽ KHÔNG BAO GIỜ được giải phóng → deadlock!
         * - finally đảm bảo unlock() LUÔN được gọi dù có lỗi hay không.
         */
        rwLock.readLock().lock();
        try {
            Integer qty = stock.get(title);
            if (qty == null) {
                return 0;
            }
            return qty;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    /**
     * Thêm sách vào kho - dùng writeLock (chỉ 1 luồng ghi tại một thời điểm).
     */
    public void addBook(String title, int qty) {
        rwLock.writeLock().lock();
        try {
            Integer current = stock.get(title);
            if (current == null) {
                current = 0;
            }
            stock.put(title, current + qty);
            System.out.println("[NHAP] " + title + " +" + qty 
                + " (tong: " + stock.get(title) + ") - " + Thread.currentThread().getName());
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * Mượn sách - dùng writeLock vì cần thay đổi dữ liệu.
     */
    public void borrow(String title, int qty) {
        rwLock.writeLock().lock();
        try {
            Integer current = stock.get(title);
            if (current == null) {
                current = 0;
            }
            if (current >= qty) {
                stock.put(title, current - qty);
                System.out.println("[MUON] " + title + " -" + qty 
                    + " (con: " + stock.get(title) + ") - " + Thread.currentThread().getName());
            } else {
                System.out.println("[MUON] " + title + " - Khong du sach (can " + qty 
                    + ", con " + current + ") - " + Thread.currentThread().getName());
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
