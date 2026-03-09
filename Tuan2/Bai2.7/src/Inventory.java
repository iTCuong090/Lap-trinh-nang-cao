public class Inventory {
    private Product[] items;
    public Inventory(Product[] initialItems) {
        this.items = initialItems;
    }

    public Product[] getItems() {
        return this.items;
    }
}