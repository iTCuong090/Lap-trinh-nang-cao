import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Singleton
        System.out.println("=== 1. Singleton Pattern ===");
        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger.log("This is a test log message.");
        System.out.println("Are logger and logger2 the same instance? " + (logger == logger2));

        // 2. Factory Method
        System.out.println("\n=== 2. Factory Method Pattern ===");
        ExportFactory pdfFactory = new PdfExportFactory();
        Export pdf = pdfFactory.createExport();
        pdf.exportFile();

        ExportFactory excelFactory = new ExcelExportFactory();
        Export excel = excelFactory.createExport();
        excel.exportFile();

        // 3. Adapter
        System.out.println("\n=== 3. Adapter Pattern ===");
        Player player = new PlayerAdapter();
        player.play("audio.mp3");

        // 4. Prototype
        System.out.println("\n=== 4. Prototype Pattern ===");
        Configuration originalConfig = new Configuration("Dark", Arrays.asList("Auth", "Logger"));
        Configuration clonedConfig = originalConfig.clone();

        System.out.println("Original Config: " + originalConfig);
        System.out.println("Cloned Config: " + clonedConfig);

        System.out.println("\nModify cloned config (change theme and add plugin)...");
        clonedConfig.setTheme("Light");
        clonedConfig.addPlugin("Billing");

        System.out.println("Original Config after clone modification: " + originalConfig);
        System.out.println("Cloned Config after modification: " + clonedConfig);
    }
}
