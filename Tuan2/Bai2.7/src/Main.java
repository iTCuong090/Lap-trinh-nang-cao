public class Main {
    public static void setPrice(Product[] arr, String price) {
        arr[0].setPrice(price);
    }
    public static void main(String[] args) {
        Product[] arr = new Product[]{new Product("id01","Laptop Lenovo","1000"), new Product("id02","Apple Iphone 17 Promax","3000")};
        Inventory kho = new Inventory(arr);
        System.out.println("Trước khi thay đổi giá laptop thành 5000 ở danh sách sản phẩm ban đầu, các đối tượng trong kho là: ");
        Product[] kho_items = kho.getItems();
        for (int i=0; i<kho_items.length; i++) {
            System.out.println(kho_items[i]);
        }
        setPrice(arr,"5000");

        System.out.println("Sau khi thay đổi:");
        kho_items = kho.getItems();
        for (int i=0; i<kho_items.length; i++) {
            System.out.println(kho_items[i]);
        }

        System.out.println("Nhận xét: Với cách làm này, thay đổi giá tiền trong danh sách sản phẩm xong giá tiền của sản phẩm trong đối tượng kho thực sự tự động thay đổi.");
    }
}