public class Account {
    public final String accountId;
    private long balance;
    private Transaction[] history; 

    public void addTransaction(Transaction t) {
        //Nếu chưa có lịch sử giao dịch thì tạo mảng mới chỉ có t.
        if (this.history == null) {
            this.history = new Transaction[]{t};
            System.out.println("Thêm giao dịch thành công. Check getHistory() (Chưa cập nhật số dư vì Dev lười)");
            return;
        }
        //Tạo mới mảng tạm có kích thước lớn hơn mảng hiện tại 1 .
        Transaction[] temp_arr = new Transaction[this.history.length+1];

        //Clone mảng tạm = mảng mới.
        for (int i=0; i<this.history.length; i++) {
            temp_arr[i] = this.history[i];
        }

        //Thêm t vào cuối mảng tạm.
        temp_arr[this.history.length] = t;

        //Gán this.history bằng mảng tạm để cập nhật lại giao dịch mới.
        this.history = temp_arr;

        System.out.println("Thêm giao dịch thành công. Check getHistory() (Chưa cập nhật số dư vì Dev lười)");
    }

    public Transaction[] getHistory() {
        return this.history;
    }

    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void hackedSetAmountFunction(String amount) {
        //history[0].amount = amount . Code này phải comment vì trình biên dịch sẽ báo lỗi nếu thực sự set như vậy.
        System.out.println("Set thành công số dư, check getHistory xem có thay đổi không?");
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", history=" + java.util.Arrays.toString(history) +
                '}';
    }
}