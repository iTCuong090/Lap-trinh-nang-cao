public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Truyền thuyết Con chó cao bằng Bộ PC","Nùng Canh Mộ",15.0);
        Book book2 = new Book("Truyền thuyết Con chó cao bằng Bộ PC","Nùng Canh Mộ",15.0);
        Book book3 = new Book("Truyền thuyết Con chó cao bằng Bộ PC","Nùng Canh Mộ",1.0);
        Book book4 = new Book("Truyền thuyết Con chó cao bằng Bộ PC","Nùng Canh Mộ",15.0);
        System.out.println(book1.equals(book2));
        System.out.println(book3.equals(book4));
        System.out.println(book4.equals(book1));
        System.out.println(book3.equals(book1));
    }
}