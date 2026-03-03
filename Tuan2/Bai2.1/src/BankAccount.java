public class BankAccount {
    public final String accountNumber;
    private double balance;
    public String ownerName;

    public BankAccount(String inputAccountNumber, String inputOwnerName, double inputBalance) {
        this.accountNumber = inputAccountNumber;
        this.ownerName = inputOwnerName;

        if (inputBalance < 0) {
            this.balance = 0;
            System.out.println("Lỗi: Số dư nhập vào phải lớn hơn 0. Đặt số dư mặc định thành 0 cho tài khoản "+this.accountNumber+" "+this.ownerName);
        }
        else {
        this.balance = inputBalance;
        }

    }

    public BankAccount(String inputAccountNumber, String inputOwnerName) {
        this(inputAccountNumber, inputOwnerName, 0.0); // Gọi thằng dưới và đưa giá trị mặc định là 0.0
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Lỗi: Số tiền nạp vào phải lớn hơn 0.");
            return;
        }
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if ((amount <= 0 ) || (amount > this.balance)) {
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }


}