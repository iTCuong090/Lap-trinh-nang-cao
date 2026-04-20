/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên hiểu:
 * 1. Race condition là gì? Khi nhiều luồng cùng đọc/ghi một biến chung
 *    mà không đồng bộ thì kết quả sẽ sai (bị "tranh chấp dữ liệu").
 * 2. Từ khóa synchronized giúp "khóa" phương thức, chỉ cho phép
 *    1 luồng thực thi tại một thời điểm → đảm bảo an toàn dữ liệu.
 * 3. Kỹ năng dùng join() để đợi luồng hoàn thành trước khi đọc kết quả.
 */
public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    /*
     * [KIẾN THỨC NÂNG CAO] Từ khóa synchronized
     * - Khi một phương thức được đánh dấu synchronized, Java sẽ tự động
     *   "khóa" đối tượng (this) khi một luồng vào phương thức.
     * - Các luồng khác muốn gọi BẤT KỲ phương thức synchronized nào
     *   của cùng đối tượng đều phải CHỜ cho đến khi luồng trước ra khỏi.
     * 
     * Vì sao cần synchronized ở đây?
     * - Giả sử balance = 1000. Luồng A đọc balance = 1000, tính 1000 + 100.
     *   Nhưng trước khi A ghi lại, luồng B cũng đọc balance = 1000, tính 1000 - 100.
     *   Kết quả: A ghi 1100, B ghi 900. Một trong hai sẽ bị mất!
     * - Với synchronized, chỉ 1 luồng được thao tác tại một thời điểm → không bị sai.
     * 
     * [LƯU Ý] synchronized làm giảm hiệu năng vì các luồng phải chờ nhau.
     * Chỉ nên dùng khi thực sự cần bảo vệ dữ liệu dùng chung.
     */
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}
