public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}

//Nhận xét: Khi gọi Constructor của các lớp con, Constructor mặc định không tham số của các lớp Cha cũng sẽ được gọi. Điều đó
//dẫn đến phản ứng dây chuyển như trên.

//Khi chuyển constructor mặc định của Person, biên dịch báo lỗi. Khi gọi Constructor của lớp con, mặc định trình biên dịch gọi
//supper() để gọi constructor của các lớp cha, tuy nhiên việc gọi supper mặc định này chỉ đúng với hàm constructor mặc định.
//Khi ta đã custom constructor ở lớp cha, việc trình biên dịch tự động gọi supper() có thể gây lỗi nên trình biên dịch báo lỗi
//biên dịch để ta phải tự thêm supper thực sự vào constructor của lớp con.

//Sửa lỗi: Thêm supper vào lớp con.