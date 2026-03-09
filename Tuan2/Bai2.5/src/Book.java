//Import class Objects chứa hàm để hash.
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        //Kiểm tra null và kiểu dữ liệu: Nếu obj không phải là Book thì không cần so sánh tiếp
        if (obj == null || getClass() != obj.getClass()) return false;
        //Ép kiểu
        Book other = (Book) obj;
        //Kiểm tra như bình thường
        if ((this.title == other.title) && (this.author == other.author) && (this.price == other.price)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // Tạo mã băm dựa trên các thuộc tính dùng để so sánh để tránh các đối tượng bằng nhau bị coi là khác nhau
        // khi sử dụng trong các kiểu dữ liệu sử dụng hash.
        return Objects.hash(this.title, this.author, this.price);
}
}