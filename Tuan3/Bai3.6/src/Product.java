import java.time.LocalDate;

public class Product {
    protected int id;
    protected String name;
    protected double price;

    public double getFinalPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static double calculateTotalRevenue(Product[] products) {
        double sum = 0;
        for (int i = 0; i<products.length; i++) {
            sum=sum+products[i].getFinalPrice();
        }
        return sum;
    }
}

class Electronics extends Product {
    protected double maintenenceFee;
    public static final double vatRate = 0.1;

    public Electronics(int id, String name, double price, double maintenenceFee) {
        super(id, name, price);
        this.maintenenceFee = maintenenceFee;
    }

    @Override
    public double getFinalPrice() {
        return price*(1+vatRate) + maintenenceFee;
    }


}

class Food extends Product {
    protected LocalDate expiredDate;
    public static final double discount = 0.2;

    public Food(int id, String name, double price, LocalDate expiredDate) {
        super(id, name, price);
        this.expiredDate = expiredDate;
    }

    public boolean isNearlyExpired() {
        long daysRemaining = expiredDate.toEpochDay() - LocalDate.now().toEpochDay();
        //Method LocalDate.toEpochDay() trả về số ngày đã qua kể từ 01/01/1970.
        if (daysRemaining < 7) {
            return true;
        }
        return false;
    }

    @Override
    public double getFinalPrice() {
        if (isNearlyExpired()) {
            return price*(1-discount);
        }
        else {
            return price;
        }
    }
}