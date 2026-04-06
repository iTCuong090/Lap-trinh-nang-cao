import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Nhập số nguyên a: ");
            int a = scanner.nextInt();
            
            System.out.print("Nhập số nguyên b: ");
            int b = scanner.nextInt();
            
            // Thực hiện phép chia
            int result = a / b;
            
            // Nếu hợp lệ, in kết quả
            System.out.println("Kết quả a / b = " + result);
            
        } catch (InputMismatchException e) {
            // Xử lý ngoại lệ khi nhập không phải số nguyên
            System.out.println("Lỗi: Dữ liệu đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
        } catch (ArithmeticException e) {
            // Xử lý ngoại lệ khi chia cho 0
            System.out.println("Lỗi: Không thể thực hiện phép chia cho 0.");
        } finally {
            System.out.println("Program finished.");
            scanner.close(); 
        }
    }
}