import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Xây dựng lớp Student có cài đặt Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Đảm bảo tính nhất quán khi serialize
    
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [ID: " + id + ", Name: " + name + ", GPA: " + gpa + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        String fileName = "students.dat";

        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ===");

        // 2. Nhập danh sách sinh viên cho tới khi gặp "END"
        System.out.println("--- NHẬP THÔNG TIN ---");
        System.out.println("Nhập 'END' vào trường ID để dừng nhập dữ liệu.");
        
        while (true) {
            System.out.print("Nhập mã sinh viên (ID): ");
            String id = scanner.nextLine();
            
            if (id.equalsIgnoreCase("END")) {
                break;
            }
            
            System.out.print("Nhập tên sinh viên: ");
            String name = scanner.nextLine();
            
            double gpa = 0.0;
            System.out.print("Nhập điểm GPA: ");
            try {
                gpa = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("GPA không hợp lệ, hệ thống sẽ gán mặc định là 0.0");
            }

            studentList.add(new Student(id, name, gpa));
            System.out.println("---");
        }

        // 3. Ghi danh sách ra tệp bằng ObjectOutputStream
        System.out.println("\n--- GHI DỮ LIỆU RA TỆP ---");
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            // Ghi từng đối tượng vào tệp
            for (Student student : studentList) {
                oos.writeObject(student);
            }
            System.out.println("Đã ghi thành công " + studentList.size() + " sinh viên vào tệp: " + fileName);
            
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp để ghi dữ liệu. Chi tiết: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi IO trong quá trình ghi tệp: " + e.getMessage());
        }

        // 4. Đọc lại từ tệp và in danh sách
        // 5. Bắt các ngoại lệ theo yêu cầu
        System.out.println("--- ĐỌC VÀ IN DỮ LIỆU TỪ TỆP ---");
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            System.out.println("Danh sách sinh viên đang lưu trong tệp:");
            // Sử dụng vòng lặp vô tận để đọc từng Object. Sẽ kết thúc khi gặp EOFException
            while (true) {
                Student student = (Student) ois.readObject();
                System.out.println(student);
            }

        } catch (EOFException e) {
            // Đây là hành vi bình thường khi đọc hết Object trong tệp
            System.out.println("Đã đọc đến cuối tệp (EOF - End Of File).");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy định nghĩa của lớp Student. Chi tiết: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp để đọc. Chi tiết: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi IO trong quá trình đọc tệp: " + e.getMessage());
        }
        
        scanner.close();
    }
}