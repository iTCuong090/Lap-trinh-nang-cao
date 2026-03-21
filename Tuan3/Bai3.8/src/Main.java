import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========Input==========");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        Robot[] robotList = new Robot[n];

        for (int i = 0; i<n; i++) {
            System.out.print("Nhập [Loại Robot] [id] [ModelName]: ");
            String robotType = sc.next();
            int robotId = sc.nextInt();
            String robotModelName = sc.next();
            sc.nextLine();

            if (robotType.equals("DR")) {
                robotList[i] = new DroneRobot(robotId, robotModelName);
            }
            if (robotType.equals("FR")) {
                robotList[i] = new FishRobot(robotId, robotModelName);
            }
            if (robotType.equals("AR")) {
                robotList[i] = new AmphibiousRobot(robotId, robotModelName);
            }
        }

        System.out.println("==========Output==========");
        for (int i = 0; i<n; i++) {
            robotList[i].performMainTask();
            System.out.println();
        }

        System.out.println("=Nhiệm vụ thêm (áp dụng instanceof để downcasting an toàn sau đó gọi method)=");

        /*
        Không thể lấy trực tiếp 1 đối tượng từ Robot[] để gọi trực tiếp method riêng của đối tượng biết bay, vv vì tham chiếu
        đang trỏ tới đối tượng Robot nói chung, trình biên dịch không cho phép điều đó.  
        
        Nếu có thêm 1 lớp trừu tượng Electronic Devices nữa thì các robot không thể extends lớp này vì java không hỗ trợ đa kế thừa đối
        với lớp. (Tức là không thể extends 2 lớp). Khi đó trình biên dịch báo lỗi.

        Nếu sau khi đã chuyển lớp trừu tượng Electronic Devices thành Interface thì hoàn toàn có thể Implement như bình thường và
        biên dịch, như những gì ta đã và đang làm hiện tại.

        */

        for (int i = 0; i<n; i++) {
            if (robotList[i] instanceof Flyable) {
                System.out.println("Phát hiện robot thứ "+(i+1)+" biết bay");
                Flyable thisRobot = (Flyable) robotList[i];
                thisRobot.Fly();
            }
            if (robotList[i] instanceof Swimmable) {
                System.out.println("Phát hiện robot thứ "+(i+1)+" biết bơi");
                Swimmable thisRobot = (Swimmable) robotList[i];
                thisRobot.Swim();
            }
            if (robotList[i] instanceof GPS) {
                System.out.println("Phát hiện robot thứ "+(i+1)+" biết lấy GPS");
                GPS thisRobot = (GPS) robotList[i];
                thisRobot.getCoordinates();
            }
            System.out.println();
        }

    }
}