public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ===\n");

        // 1. Tạo SV1 bằng Constructor không tham số
        Student sv1 = new Student();
        System.out.println("Khởi tạo sv1 (No-arg): Done.");

        // 2. Tạo SV2 bằng Constructor (id, name)
        Student sv2 = new Student("UET_001", "Nguyễn Văn Cường");
        System.out.println("Khởi tạo sv2 (Partial-args): Done.");

        // 3. Tạo SV3 bằng Copy Constructor (Sao chép từ sv2)
        Student sv3 = new Student(sv2);
        System.out.println("Khởi tạo sv3 (Copy Constructor từ sv2): Done.");

        System.out.println("\n--- THỰC NGHIỆM VALIDATION GPA ---");
        // Thử gán GPA < 0 cho sv2
        System.out.print("Gán GPA = -1.5 cho sv2: ");
        sv2.setGpa(-1.5); 
        
        // Thử gán GPA hợp lệ cho sv3
        System.out.print("Gán GPA = 3.8 cho sv3: ");
        sv3.setGpa(3.8);

        System.out.println("\n--- THÔNG TIN CHI TIẾT ---");
        printStudent(sv1, "Sinh viên 1");
        printStudent(sv2, "Sinh viên 2");
        printStudent(sv3, "Sinh viên 3 (Bản sao)");
    }

    // Hàm phụ trợ để in thông tin bằng Getter
    public static void printStudent(Student s, String label) {
        System.out.println(label + " -> [ID: " + s.getId() + 
                           " | Tên: " + s.getName() + 
                           " | Email: " + s.getEmail() + 
                           " | GPA: " + s.getGpa() + "]");
    }
}