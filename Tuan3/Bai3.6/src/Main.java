import java.util.Scanner;
import java.time.LocalDate;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============Input=============");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        
        sc.nextLine();

        Product[] data = new Product[n];

        for (int i = 0; i<n; i++) {
            System.out.print("Nhập sản phẩm thứ "+(i+1)+": ");
            String input = sc.nextLine();

            // 1. Lấy phần tử đầu tiên (trước khoảng trắng đầu tiên)
            int firstSpace = input.indexOf(" ");
            String part1 = input.substring(0, firstSpace);

            // 2. Lấy nội dung trong dấu ngoặc kép
            int firstQuote = input.indexOf("\"");
            int lastQuote = input.lastIndexOf("\"");
            String name = input.substring(firstQuote + 1, lastQuote);

            // 3. Lấy phần còn lại sau dấu ngoặc kép cuối cùng
            String remaining = input.substring(lastQuote + 1).trim();
                
            // 4. Tách các con số hoặc ngày còn lại bằng split cơ bản
            String[] numbers_or_date_string = remaining.split(" ");

            if (part1.equals("E")) {
                double price = Double.parseDouble(numbers_or_date_string[0]);
                double fee = Double.parseDouble(numbers_or_date_string[1]);

                data[i] = new Electronics(i,name,price,fee);
            }

            if (part1.equals("F")) {
                double price = Double.parseDouble(numbers_or_date_string[0]);
                LocalDate expiredDate = LocalDate.parse(numbers_or_date_string[1]);

                data[i] = new Food(i,name,price,expiredDate);
            }

            
            
        }

        System.out.println("============Output=============");

        for (int i = 0; i<n; i++) {
            String type;
            if (data[i] instanceof Electronics) {
                type = "Electronics";
            }
            else {
                type = "Food";
            }
            System.out.println(data[i].getName()+" - "+type+" - "+data[i].getFinalPrice());
        }

        System.out.println("Total = "+Product.calculateTotalRevenue(data));

    }
}
