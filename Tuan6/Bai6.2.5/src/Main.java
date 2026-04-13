public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        //Kiểm tra xem hai biến logger có cùng trỏ về một địa chỉ bộ nhớ (cùng một instance) không
        System.out.println("Logger instances equal: " + (logger1 == logger2));

        // Ghi các log khác nhau thông qua các biến khác nhau 
        // đều sẽ gọi qua cùng một đối tượng duy nhất singleton.
        logger1.logInfo("Application started");
        logger2.logInfo("Processing data...");
        logger1.logError("Something went wrong");
    }
}