import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- NHẬP DỮ LIỆU ---
        Product p1 = inputProduct(sc, 1);
        Product p2 = inputProduct(sc, 2);

        // --- THỰC HIỆN GIAO DỊCH ---
        System.out.print("\nNhập số lượng mua cho " + "p1: ");
        p1.sell(sc.nextInt());
        System.out.print("Nhập số lượng mua cho " + "p2: ");
        p2.sell(sc.nextInt());

        // --- KIỂM TRA TÍNH STATIC ---
        System.out.println("\n--- 1. Giá cuối cùng (Thuế mặc định 10%) ---");
        System.out.println("P1: " + p1.calculateFinalPrice());
        System.out.println("P2: " + p2.calculateFinalPrice());

        System.out.println("\n--- 2. Sau khi Product.updateTaxRate(0.08) ---");
        Product.updateTaxRate(0.08); // Gọi qua tên lớp
        System.out.println("P1: " + p1.calculateFinalPrice());
        System.out.println("P2: " + p2.calculateFinalPrice());

        System.out.println("\n--- 3. Sau khi p1.updateDiscount(10.0) ---");
        p1.updateDiscount(10.0); // Chỉ ảnh hưởng p1
        System.out.println("P1: " + p1.calculateFinalPrice());
        System.out.println("P2: " + p2.calculateFinalPrice());

        // --- TỔNG DOANH THU ---
        System.out.println("\n====================================");
        System.out.println("TỔNG DOANH THU TOÀN HỆ THỐNG: " + Product.getTotalRevenue());
    }

    // Hàm phụ trợ để nhập liệu cho gọn code main
    private static Product inputProduct(Scanner sc, int id) {
        System.out.println("Nhập SP " + id + " (Tên, Giá, SL, Giảm giá):");
        String name = sc.next();
        double price = sc.nextDouble();
        int qty = sc.nextInt();
        double discount = sc.nextDouble();
        return new Product(name, price, qty, discount);
    }
}