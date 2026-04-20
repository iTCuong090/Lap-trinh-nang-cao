public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Tạo tài khoản với số dư ban đầu = 0
        BankAccount account = new BankAccount(0);

        /*
         * Luồng A: Nạp tiền 1000 lần, mỗi lần 100đ
         * → Tổng nạp = 1000 x 100 = 100,000đ
         */
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    account.deposit(100);
                }
            }
        });

        /*
         * Luồng B: Rút tiền 1000 lần, mỗi lần 100đ
         * → Tổng rút = 1000 x 100 = 100,000đ
         */
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    account.withdraw(100);
                }
            }
        });

        // Khởi chạy cả 2 luồng đồng thời
        threadA.start();
        threadB.start();

        /*
         * [KIẾN THỨC] join() - Đợi luồng hoàn thành
         * - threadA.join() → luồng main sẽ DỪNG lại và chờ threadA kết thúc.
         * - Nếu không join(), main có thể in kết quả trước khi luồng kết thúc
         *   → kết quả sẽ sai (in giữa chừng).
         */
        threadA.join();
        threadB.join();

        /*
         * Kỳ vọng: balance = 0 (nạp 100,000 - rút 100,000 = 0).
         * Nếu KHÔNG dùng synchronized ở BankAccount, kết quả sẽ sai
         * do race condition (thử bỏ synchronized để thấy lỗi).
         */
        System.out.println("Final balance: " + account.getBalance());
    }
}
