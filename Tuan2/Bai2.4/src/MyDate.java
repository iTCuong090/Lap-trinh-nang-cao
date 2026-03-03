public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    public String toString() {
        // %02d giúp tự động thêm số 0 ở phía trước nếu chỉ có 1 chữ số
        return String.format("%02d/%02d/%d", day, month, year);
    }

    public void setDay(int day) {
        // Kiểm tra logic cơ bản: ngày phải từ 1 đến 31
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            System.out.println("Ngày không hợp lệ!");
        }
    }

    public void setMonth(int month) {
        // Kiểm tra tháng từ 1 đến 12
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Tháng không hợp lệ!");
        }
    }

    public void setYear(int year) {
        // Năm thường là số dương
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("Năm không hợp lệ!");
        }
    }
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
}