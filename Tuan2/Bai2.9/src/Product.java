public class Product {
    private String name;
    private double price, discount;
    private int quantity;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        return (price - discount)*(1 + taxRate);
    }

    public void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            quantity = quantity - amount;
            totalRevenue = totalRevenue + amount*this.calculateFinalPrice();
            System.out.println("Thực hiện lệnh bán thành công");
        }
        else {
            System.err.println("Không đủ hàng trong kho");
        }
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }
    


}