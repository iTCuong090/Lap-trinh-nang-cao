import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============Input=============");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        
        sc.nextLine();

        Employee[] data = new Employee[n];

        for (int i = 0; i<n; i++) {
            System.out.print("Nhập nhân viên thứ "+(i+1)+": ");
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
                
            // 4. Tách các con số còn lại bằng split cơ bản
            String[] numbers_string = remaining.split(" ");

            double[] numbers = new double[numbers_string.length];

            for (int j =0; j< numbers_string.length; j++) {
                numbers[j] = Double.parseDouble(numbers_string[j]);
            }
            
            if (part1.equals("F")) {
                data[i] = new FullTimeEmployee(name, numbers[0], numbers[1], numbers[2]);
            }
            
            if (part1.equals("P")) {
                data[i] = new PartTimeEmployee(name, numbers[0], numbers[1]);
            }
            
        }

        System.out.println("============Output=============");

        for (int i = 0; i<n; i++) {
            String type;
            if (data[i] instanceof FullTimeEmployee) {
                type = "Full-time";
            }
            else {
                type = "Part-time";
            }
            System.out.println(data[i].getName()+" - "+type+" - "+data[i].getSalary());
        }




    }
}
