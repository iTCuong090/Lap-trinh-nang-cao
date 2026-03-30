import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========Input==========");
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        BookSection bookSection = new BookSection();
        DVDSection dvdSection = new DVDSection();

        for (int i=0;i<n;i++) {
            System.out.print("Nhập thông tin tài liệu thứ "+(i+1)+": ");
            String type = sc.next();

            if (type.equals("B")) {
                String id = sc.next();
                String name = sc.next();
                String author = sc.next();
                int pages = sc.nextInt();
                bookSection.add(new Book(id,name,author,pages));
            }

            if (type.equals("D")) {
                String id = sc.next();
                String name = sc.next();
                String author = sc.next();
                int duration = sc.nextInt();
                dvdSection.add(new DVD(id,name,author,duration));
            }
        }

        System.out.println("==========Output==========");
        System.out.println("Khu chứa sách: ");
        bookSection.check();
        System.out.println("Khu chứa DVD: ");
        dvdSection.check();
    }
}