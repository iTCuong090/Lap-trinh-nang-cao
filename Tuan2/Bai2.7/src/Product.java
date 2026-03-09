public class Product {
    private String id, name, price;

    public Product(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setPrice(String amount) {
        this.price = amount;
    }

    @Override
    public String toString() {
     return "Product [ID=" + id + ", Name=" + name + ", Price=" + price + "]";
    }


}