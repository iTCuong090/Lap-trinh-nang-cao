import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Input==========");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        IPayable[] payableList = new IPayable[n];

        for (int i = 0; i<n; i++) {
            System.out.print("Nhập thông tin đối tượng "+(i+1)+":");
            String type = sc.next();

            if (type.equals("S")) {
                String id = sc.next();
                String name = sc.next();
                int workingHours = sc.nextInt();
                double hourlyRate = sc.nextDouble();

                payableList[i] = new PartTimeStaff(id,name,workingHours,hourlyRate);
            }

            if (type.equals("I")) {
                String itemName = sc.next();
                int quantity = sc.nextInt();
                double pricePerItem = sc.nextDouble();

                payableList[i] = new Invoice(itemName, quantity, pricePerItem);
            }

            sc.nextLine();
        }

        System.out.println("==========Output==========");
        double total = 0;
        for (int i = 0 ; i < n; i++) {
            total = total + payableList[i].getPaymentAmount();

            IPayable thing = payableList[i];
            
            if (thing instanceof PartTimeStaff) {
                PartTimeStaff object = (PartTimeStaff) thing;
                System.out.println("PartTimeStaff " + object.getName() + " - Payment: " + object.getPaymentAmount());
            }

             if (thing instanceof Invoice) {
                Invoice object = (Invoice) thing;
                System.out.println("Invoice " + object.getName() + " - Payment: " + object.getPaymentAmount());
            }
        }

        System.out.println("Total Payment = "+total);

    }
}