import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' +
                ", author='" + author + '\'' + ", year=" + year + '}';
    }
}

// Interface chung cho các hệ thống quản lý để dễ gọi trong Main
public interface LibraryManager {
    void addBook(Book book);
    Book searchBookById(String id);
    void deleteBookById(String id);
    void printAllBooks();
}

// 2.1 Phiên bản quản lý bằng ArrayList
class ArrayListLibrary implements LibraryManager {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book searchBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void deleteBookById(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void printAllBooks() {
        System.out.println("--- Danh sách sách (ArrayList) ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// 2.2 Phiên bản quản lý bằng HashMap
class HashMapLibrary implements LibraryManager {
    private Map<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book); // Key là id sách
    }

    @Override
    public Book searchBookById(String id) {
        return books.get(id); // Truy xuất trực tiếp bằng key
    }

    @Override
    public void deleteBookById(String id) {
        books.remove(id);
    }

    @Override
    public void printAllBooks() {
        System.out.println("--- Danh sách sách (HashMap) ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}

// 2.3 Phiên bản quản lý bằng TreeMap
class TreeMapLibrary implements LibraryManager {
    private Map<String, Book> books = new TreeMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book); // Tự động sắp xếp theo Key (id)
    }

    @Override
    public Book searchBookById(String id) {
        return books.get(id);
    }

    @Override
    public void deleteBookById(String id) {
        books.remove(id);
    }

    @Override
    public void printAllBooks() {
        System.out.println("--- Danh sách sách (TreeMap) ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}
