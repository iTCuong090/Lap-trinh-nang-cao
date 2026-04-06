import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên tệp cần đọc (ví dụ: numbers.dat): ");
        String fileName = scanner.nextLine();

        System.out.println("Đang đọc dữ liệu từ tệp " + fileName + "...");
        
        // Sử dụng try-with-resources để tự động đóng DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (true) {
                // Đọc từng số nguyên. Khi hết file sẽ tự động ném ra EOFException
                int number = dis.readInt();
                System.out.print(number + " ");
            }
        } catch (EOFException e) {
            // Bắt lỗi EOFException để kết thúc quá trình đọc một cách chủ động
            System.out.println("[Hoàn tất] Đã đọc đến cuối tệp.");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy tệp '" + fileName + "'. Vui lòng kiểm tra lại tên tệp.");
        } catch (IOException e) {
            System.out.println("Lỗi Input/Output khi đọc tệp: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}