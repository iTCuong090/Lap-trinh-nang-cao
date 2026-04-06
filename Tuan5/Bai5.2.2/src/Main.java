import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập đường dẫn tệp
        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String destinationPath = scanner.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            // Kiểm tra tệp nguồn trước để ném lỗi chính xác
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists() || sourceFile.isDirectory()) {
                throw new FileNotFoundException("Source file not found.");
            }

            // Dùng FileReader + BufferedReader để đọc
            reader = new BufferedReader(new FileReader(sourceFile));

            // Cố gắng tạo luồng ghi để bắt lỗi không tạo được tệp đích
            try {
                //Dùng FileWriter + PrintWriter để ghi
                writer = new PrintWriter(new FileWriter(destinationPath));
            } catch (IOException e) {
                throw new FileNotFoundException("Cannot create destination file.");
            }

            // Đọc và ghi từng dòng
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }

            //In số dòng đã sao chép nếu thành công
            System.out.println("Sao chép thành công. Số dòng đã sao chép: " + lineCount);

        } catch (FileNotFoundException e) {
            // Xử lý FileNotFoundException với thông báo tương ứng
            System.out.println(e.getMessage());
        } catch (IOException e) {
            //Xử lý IOException và in stack trace
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng tệp trong finally
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng tệp nguồn: " + e.getMessage());
            }
            
            if (writer != null) {
                // PrintWriter có phương thức close() không ném ra IOException
                writer.close(); 
            }
            scanner.close();
        }
    }
}