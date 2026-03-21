import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Input==========");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employeeList = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập thông tin nhân viên thứ "+(i+1)+": ");
            String type = sc.next();

            if (type.equals("E")) {
                String name = sc.next();
                double baseSalary = sc.nextDouble();

                employeeList[i] = new Employee(name, baseSalary);
            }

            if (type.equals("D")) {
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                int overtimeHours = sc.nextInt();

                employeeList[i] = new Developer(name, baseSalary, overtimeHours);
            }

            if (type.equals("T")) {
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                int bugsFound = sc.nextInt();

                employeeList[i] = new Tester(name, baseSalary, bugsFound);
            }

            sc.nextLine();
        }

        System.out.println("==========Output==========");

        for (int i=0; i<n; i++) {
            Employee person = employeeList[i];
            System.out.println(person.name+" - Bonus: "+person.calculateBonus());

            if (employeeList[i] instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            }

            if (employeeList[i] instanceof Tester) {
                System.out.println("Tặng tool Test");
            }

            System.out.println();
        }
    }
}