import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên tệp để ghi (ví dụ: numbers.dat): ");
        String fileName = scanner.nextLine();

        System.out.print("Nhập số lượng phần tử n: ");
        int n = scanner.nextInt();

        // Sử dụng try-with-resources để tự động đóng DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
                int number = scanner.nextInt();
                dos.writeInt(number); // Ghi số nguyên dưới dạng nhị phân
            }
            System.out.println("Đã ghi thành công " + n + " số vào tệp " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi Input/Output khi ghi tệp: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}