public class Main {
    public static void main(String[] args) {
        // 1. Tạo emp1 với ngày sinh 1/1/2000
        MyDate date1 = new MyDate(1, 1, 2000);
        Employee emp1 = new Employee("Cường UET", date1);

        // 2. Tạo emp2 bằng cách sao chép emp1 (Sử dụng Copy Constructor)
        Employee emp2 = new Employee(emp1);

        System.out.println("--- Trước khi thay đổi ---");
        System.out.println("emp1: " + emp1);
        System.out.println("emp2: " + emp2);

        // 3. Thay đổi nội dung ngày sinh của emp1 thành 2/2/2022
        // Giả sử class MyDate có setter hoặc thuộc tính là public để ta can thiệp vào vùng nhớ
        // Nếu đây là Deep Copy, việc sửa vùng nhớ của date1 sẽ không ảnh hưởng đến emp2
        date1.setDay(2);   // Hoặc date1.day = 2;
        date1.setMonth(2); // Hoặc date1.month = 2;
        date1.setYear(2022); // Hoặc date1.year = 2022;

        System.out.println("\n--- Sau khi thay đổi emp1 (Deep Copy Test) ---");
        System.out.println("emp1: " + emp1);
        System.out.println("emp2: " + emp2);

        // 4. Kiểm tra và chứng minh
        if (emp1.toString().contains("02/02/2022") && emp2.toString().contains("01/01/2000")) {
            System.out.println("\n=> KẾT QUẢ: Deep Copy THÀNH CÔNG!");
            System.out.println("Giải thích: Khi sửa đối tượng MyDate của emp1, emp2 vẫn giữ giá trị cũ.");
        } else {
            System.out.println("\n=> KẾT QUẢ: Vẫn đang là Shallow Copy!");
            System.out.println("Giải thích: Cả 2 nhân viên đang trỏ chung vào 1 vùng nhớ ngày sinh.");
        }
    }
}