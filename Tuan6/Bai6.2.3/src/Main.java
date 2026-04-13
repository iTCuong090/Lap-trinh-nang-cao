public class Main {
    public static void main(String[] args) {
        Report report = new Report("Hello World!", "Đây là một thông báo chào thế giới thôi");

        ReportFormatter jsonFormatter = new JsonFormatter();
        ReportService service1 = new ReportService(jsonFormatter);
        System.out.println(service1.export(report));

        System.out.println("-------------------------");

        ReportFormatter xmlFormatter = new XmlFormatter();
        ReportService service2 = new ReportService(xmlFormatter);
        System.out.println(service2.export(report));
    }
}