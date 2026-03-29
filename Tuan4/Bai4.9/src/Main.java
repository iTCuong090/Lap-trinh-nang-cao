import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========Input==========");
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        FoodStorage foodStorage = new FoodStorage();
        ElectricStorage electricStorage = new ElectricStorage();

        for (int i=0;i<n;i++) {
            System.out.print("Nhập thông tin mặt hàng thứ "+(i+1)+": ");
            String type = sc.next();

            if (type.equals("F")) {
                String id = sc.next();
                String name = sc.next();
                String expiryDate = sc.next();
                foodStorage.add(new Food(id,name,expiryDate));
            }

            if (type.equals("E")) {
                String id = sc.next();
                String name = sc.next();
                int warrantyMonths = sc.nextInt();
                electricStorage.add(new Electric(id,name,warrantyMonths));
            }
        }

        System.out.println("==========Output==========");
        System.out.println("Kho thực phẩm: ");
        foodStorage.check();
        System.out.println("Kho điện tử: ");
        electricStorage.check();
    }
}