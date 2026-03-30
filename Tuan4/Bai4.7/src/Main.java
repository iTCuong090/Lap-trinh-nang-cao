import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========Input==========");
        System.out.print("Nhập n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> studentList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            System.out.print("Nhập học sinh thứ "+(i+1)+": ");
            String id = sc.next();
            String name = sc.next();
            String email = "No email";
            double gpa = sc.nextDouble();

            studentList.add(new Student(id,name,email,gpa));
        }

        System.out.println("==========Output==========");
        System.out.println("After removing gpa < 5.0:");

        studentList.removeIf(student -> student.getGpa() < 5.0);
        for (Student student: studentList) {
            System.out.println(student.getId()+" - "+student.getName()+" - "+student.getGpa());
        }

        System.out.println("After sorting by name");

        studentList.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        for (Student student: studentList) {
            System.out.println(student.getId()+" - "+student.getName()+" - "+student.getGpa());
        }



    }

    //Ứng dụng Lambda viết hàm custom.
    //Note: Một tham chiếu kiểu FunctionalInterface có khả năng được gán cho 1 lambda expression.
    //Hàm calcaulate nhận vào a, b và "cách tính a, b thông qua lambda expression" và trả về kết quả.
    public static double calculate(double a, double b, Operation<Double> op) { //Trước để Operation<double> thì bị lỗi do double là kiểu nguyên thủy, ở đây cần kiểu wrapper.
        return op.execute(a, b);
    }

    //Phép cộng ứng dụng lambda expression ở trong hàm (bằng cách gọi thông qua hàm calculate):
    public static double add(double a, double b) {
        return calculate(a,b,(x,y)->x+y);
    }

    //Phép trừ:
    public static double subtract(double a, double b) {
        return calculate(a,b,(x,y)->x-y);
    }

    //Phép nhân:
    public static double multiply(double a, double b) {
        return calculate(a,b,(x,y)->x*y);
    }

    //Phép chia:
    public static double divide(double a, double b) {
        return calculate(a,b,(x,y)->x/y);
    }
}

@FunctionalInterface //Thêm anntonation để trình biên dịch kiểm tra hộ xem interface mình viết có thỏa mãn 1 functionalInterface không.
interface Operation<T> {
   T execute(T a, T b);
}