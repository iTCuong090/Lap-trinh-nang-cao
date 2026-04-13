public class ReportService {
    private ReportFormatter formatter;

    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);
    }
}

class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

interface ReportFormatter {
    String format(Report data);
}

class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "{\n  \"title\": \"" + data.getTitle() + "\",\n  \"content\": \"" + data.getContent() + "\"\n}";
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "<report>\n  <title>" + data.getTitle() + "</title>\n  <content>" + data.getContent()
                + "</content>\n</report>";
    }
}
