public class AppConfig {
    protected String appName;
    protected String version;
    protected String logLevel;

    private static class InstanceHolder {
        private static final AppConfig instance = new AppConfig();
    }

    private AppConfig(){};

    public static AppConfig getInstance() {
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {
        // Tạo nhiệm vụ (Task) cho luồng, khai báo một đối tượng runnable bằng lambda function :)
        Runnable task = () -> {
            AppConfig config = AppConfig.getInstance();
            System.out.println("Luồng " + Thread.currentThread().getName() + 
                               " - HashCode: " + config.hashCode());
        };

        // Khởi tạo 2 luồng chạy song song
        Thread thread1 = new Thread(task, "A"); // Truyền đối tượng runnable vào cho thread để thread chạy, đặt tên là A, B.
        Thread thread2 = new Thread(task, "B");

        // Bắt đầu chạy
        thread1.start();
        thread2.start();
    }

}