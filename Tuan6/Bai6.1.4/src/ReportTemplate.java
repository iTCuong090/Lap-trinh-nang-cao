import java.util.ArrayList;
import java.util.List;

public class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = new ArrayList<>(sections);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void setSections(List<String> sections) {
        this.sections = new ArrayList<>(sections);
    }

    public void addSection(String section) {
        this.sections.add(section);
    }

    @Override
    public ReportTemplate clone() {
        try {
            ReportTemplate cloned = (ReportTemplate) super.clone();
            // Sử dụng phương thức clone của lớp Object để nhờ máy ảo Java clone hộ một
            // object
            // mới toanh, sau đó ép kiểu ngược về ReportTemplate.
            cloned.sections = new ArrayList<>(this.sections);
            // Vì clone ở trên copy địa chỉ ô nhớ của ArrayList cũ nên phải tự tay gán lại
            // List mới được tạo ra bởi copy constructor của ArrayList.
            // Chú ý: Nếu các đối tượng bên trong ArrayList là mutable thì phải clone thủ
            // công hơn nữa.
            // Chui vào từng đối tượng trong arraylist và clone ra đối tượng mới.
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        // Method clone yêu cầu phải setup try catch để đề phòng.
    }

    @Override
    public String toString() {
        return "ReportTemplate{" +
                "title='" + title + '\'' +
                ", footer='" + footer + '\'' +
                ", sections=" + sections +
                '}';
    }
}
