public class Main {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO TÀI KHOẢN ---");
        
        // 1. Test Constructor 3 tham số với số dư âm
        System.out.println("Kịch bản 1: Tạo tài khoản với số dư ban đầu âm (-500k)");
        BankAccount account1 = new BankAccount("VCB123", "Nguyen Van A", -500000);
        System.out.println("Số dư hiện tại của " + account1.ownerName + ": " + account1.getBalance());
        System.out.println("--------------------------");

        // 2. Test Constructor 2 tham số (mặc định số dư = 0)
        BankAccount account2 = new BankAccount("BIDV456", "Tran Thi B");
        
        System.out.println("--- KIỂM TRA LOGIC NẠP TIỀN (DEPOSIT) ---");
        
        // Kịch bản: Nạp tiền âm
        System.out.println("Kịch bản 2: Nạp số tiền âm (-100k)");
        account2.deposit(-100000); 
        System.out.println("Số dư sau khi nạp lỗi: " + account2.getBalance());
        
        // Kịch bản: Nạp tiền hợp lệ
        System.out.println("\nKịch bản 3: Nạp tiền hợp lệ (1 triệu)");
        account2.deposit(1000000);
        System.out.println("Số dư sau khi nạp: " + account2.getBalance());
        System.out.println("--------------------------");

        System.out.println("--- KIỂM TRA LOGIC RÚT TIỀN (WITHDRAW) ---");

        // Kịch bản: Rút quá số dư
        System.out.println("Kịch bản 4: Rút quá số dư hiện có (Rút 1.5 triệu khi chỉ có 1 triệu)");
        boolean result1 = account2.withdraw(1500000);
        if (result1) {
            System.out.println("Rút tiền thành công!");
        } else {
            System.out.println("Rút tiền thất bại! (Số dư không đủ hoặc số tiền không hợp lệ)");
        }
        System.out.println("Số dư hiện tại: " + account2.getBalance());

        // Kịch bản: Rút tiền hợp lệ
        System.out.println("\nKịch bản 5: Rút tiền hợp lệ (400k)");
        boolean result2 = account2.withdraw(400000);
        if (result2) {
            System.out.println("Rút tiền thành công!");
        } else {
            System.out.println("Rút tiền thất bại!");
        }
        System.out.println("Số dư cuối cùng: " + account2.getBalance());

        System.out.println("--------------------------");
        System.out.println("--- KIỂM TRA TÍNH ĐÓNG GÓI ---");
        // Lưu ý: Các dòng dưới đây nếu bỏ comment sẽ gây lỗi biên dịch (Compile Error)
        //account2.balance = 999999999; // LỖI: balance là private
        //account2.accountNumber = "HACKED"; // LỖI: accountNumber là read-only/final
    }
}