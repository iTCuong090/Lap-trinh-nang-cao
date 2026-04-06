
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String filePath = scanner.nextLine();
        scanner.close();

        Map<String, String> configMap = new HashMap<>();
        BufferedReader br = null;

        try {
            // 1. Đọc file theo từng dòng
            br = new BufferedReader(new FileReader(filePath));
            String line;
            
            // 2. Tách key=value và lưu vào Map
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Bỏ qua dòng trống
                
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configMap.put(key, value);
                }
            }

            // 3. Kiểm tra dữ liệu
            if (!configMap.containsKey("username")) {
                throw new InvalidConfigException("Missing 'username'");
            }
            
            if (!configMap.containsKey("timeout")) {
                throw new InvalidConfigException("Missing 'timeout'");
            }
            
            int timeout = Integer.parseInt(configMap.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("'timeout' must be > 0");
            }

            if (configMap.containsKey("maxConnections")) {
                int maxConnections = Integer.parseInt(configMap.get("maxConnections"));
                if (maxConnections < 1) {
                    throw new InvalidConfigException("'maxConnections' must be >= 1");
                }
            }

            // Nếu cấu hình hợp lệ, in toàn bộ và thông báo thành công
            System.out.println("--- Dữ liệu cấu hình ---");
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            System.out.println("Config loaded successfully.");

        // 4. Xử lý ngoại lệ
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            // 5. Đảm bảo đóng file trong finally
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error closing file.");
                }
            }
            // 6. Dù lỗi hay không, luôn in: Program finished.
            System.out.println("Program finished.");
        }
    }
}