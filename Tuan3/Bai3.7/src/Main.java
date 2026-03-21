import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Input==========");
        System.out.print("Nhập [S/ V]khoảng_cách[số đêm ở]: ");
        String roomType = sc.next();
        int numNights = sc.nextInt();

        Room rentedRoom = null; //Gán null để fix lỗi Complier sợ rentroom sẽ không bao giờ được gắn với đối tượng nào.

        if (roomType.equals("S")) {
            rentedRoom = new StandardRoom("random room id",numNights);
        }

        if (roomType.equals("V")) {
            rentedRoom = new VipRoom("random room id",numNights);
        }
        System.out.println("==========Output==========");
        System.out.println(Math.round(rentedRoom.calculateFinalPrice()));
    }
}