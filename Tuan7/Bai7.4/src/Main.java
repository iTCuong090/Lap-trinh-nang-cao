public class Main {
    public static void main(String[] args) throws InterruptedException {
        BookStore store = new BookStore();

        // Khởi tạo một vài sách có sẵn trong kho
        store.addBook("Java Core", 10);
        store.addBook("Clean Code", 5);
        store.addBook("Design Patterns", 3);

        System.out.println("--- Bat dau cac luong doc/ghi dong thoi ---");

        // Tạo 3 luồng ĐỌC (in số lượng sách)
        Thread reader1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("[DOC] Java Core: " + store.getStock("Java Core") 
                    + " - " + Thread.currentThread().getName());
            }
        }, "Reader-1");

        Thread reader2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("[DOC] Clean Code: " + store.getStock("Clean Code") 
                    + " - " + Thread.currentThread().getName());
            }
        }, "Reader-2");

        Thread reader3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("[DOC] Design Patterns: " + store.getStock("Design Patterns") 
                    + " - " + Thread.currentThread().getName());
            }
        }, "Reader-3");

        // Tạo 2 luồng GHI (mượn/nhập sách)
        Thread writer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                store.borrow("Java Core", 3);
                store.addBook("Clean Code", 2);
            }
        }, "Writer-1");

        Thread writer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                store.borrow("Design Patterns", 1);
                store.addBook("Java Core", 5);
            }
        }, "Writer-2");

        // Chạy tất cả các luồng đồng thời
        reader1.start();
        writer1.start();
        reader2.start();
        writer2.start();
        reader3.start();

        // Đợi tất cả hoàn thành
        reader1.join();
        reader2.join();
        reader3.join();
        writer1.join();
        writer2.join();

        System.out.println("--- Ket qua cuoi cung ---");
        System.out.println("Java Core: " + store.getStock("Java Core"));
        System.out.println("Clean Code: " + store.getStock("Clean Code"));
        System.out.println("Design Patterns: " + store.getStock("Design Patterns"));
    }
}
