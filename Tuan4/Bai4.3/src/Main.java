import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Input==========");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employeeList = new Employee[n];

        for (int i=0;i<n;i++) {
            System.out.print("Nhập thông tin nhân viên thứ "+(i+1)+": ");
            String type = sc.next();

            if (type.equals("O")) {
                String id = sc.next();
                String name = sc.next();
                double baseSalary = sc.nextDouble();

                employeeList[i] = new OfficeWorker(id,name,baseSalary);
            }

            if (type.equals("T")) {
                String id = sc.next();
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                int overtimeHours = sc.nextInt();

                employeeList[i] = new Technician(id,name,baseSalary,overtimeHours);
            }
        }

        System.out.println("==========Output==========");

        double totalPay = 0;
        for (int i=0;i<n;i++) {
            Employee obj = employeeList[i];
            System.out.println(obj.name+"- Pay:"+obj.calculatePay());
            obj.work();
            System.out.println();
            totalPay += obj.calculatePay();
        }

        System.out.println("Total Pay = "+totalPay);
    
    }
}