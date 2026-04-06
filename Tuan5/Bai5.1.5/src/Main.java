// Lớp Main để chạy và kiểm thử
public class Main {
    public static void main(String[] args) {
        // Tạo sẵn 5 cuốn sách
        Book b1 = new Book("B04", "Clean Code", "Robert C. Martin", 2008);
        Book b2 = new Book("B01", "Design Patterns", "Gang of Four", 1994);
        Book b3 = new Book("B05", "Effective Java", "Joshua Bloch", 2017);
        Book b4 = new Book("B02", "Refactoring", "Martin Fowler", 1999);
        Book b5 = new Book("B03", "Head First Java", "Kathy Sierra", 2003);

        // Khởi tạo 3 hệ thống
        LibraryManager arrayListLib = new ArrayListLibrary();
        LibraryManager hashMapLib = new HashMapLibrary();
        LibraryManager treeMapLib = new TreeMapLibrary();

        LibraryManager[] libraries = {arrayListLib, hashMapLib, treeMapLib};

        for (LibraryManager lib : libraries) {
            System.out.println("\n========== THỬ NGHIỆM VỚI: " + lib.getClass().getSimpleName() + " ==========");
            
            // 1. Thêm ít nhất 5 cuốn sách
            lib.addBook(b1);
            lib.addBook(b2);
            lib.addBook(b3);
            lib.addBook(b4);
            lib.addBook(b5);

            // In danh sách ban đầu (Để ý thứ tự in của TreeMap sẽ tự động sắp xếp B01 -> B05)
            lib.printAllBooks();

            // 2. Thực hiện tìm kiếm
            String searchId = "B02";
            System.out.println("\n-> Tìm kiếm sách có ID = " + searchId);
            Book foundBook = lib.searchBookById(searchId);
            System.out.println(foundBook != null ? "Tìm thấy: " + foundBook : "Không tìm thấy sách!");

            // 3. Thực hiện xóa
            String deleteId = "B04";
            System.out.println("\n-> Xóa sách có ID = " + deleteId);
            lib.deleteBookById(deleteId);

            // 4. In danh sách kết quả sau khi xóa
            lib.printAllBooks();
        }
    }
}