

public class Main {
    public static void displayArray(Transaction[] arr) {
    System.out.print("Hiển thị mảng: ");
    for (Transaction x : arr) {
        System.out.print(x + " ");
    }
    System.out.println(); // Xuống dòng sau khi in xong
}
    public static void main(String[] args) {
        System.out.println("===Ngân hàng===");
        System.out.println("Tạo tài khoản mới với id 067, số dư 67 đô.");
        Account account1 = new Account("067",67);
        System.out.println("Check lịch sử giao dịch( mong đợi null vì chưa có gì): ");
        System.out.println(account1.getHistory());
        System.out.println("Thêm giao dịch mới: id=abc; ammount = 6767; timestamp=xyz ");
        account1.addTransaction(new Transaction("abc","6767","xyz"));
        displayArray(account1.getHistory());
        System.out.println("Thêm giao dịch mới: id=123; ammount = 6768; timestamp=abc ");
        account1.addTransaction(new Transaction("123","6768","abc"));
        displayArray(account1.getHistory());

        System.out.println("===Hacker===");
        System.out.println("Gọi getHistory:");
        displayArray(account1.getHistory());
        System.out.println("Thay đổi account1.history[0].amount = 9999");
        account1.hackedSetAmountFunction("9999");
        System.out.println("Kiểm tra lại getHistory:");
        displayArray(account1.getHistory());
        
        
    }
}