import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========Input==========");
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        sc.nextLine();

        Hub hub = new Hub();

        for (int i=0; i<n; i++) {
            System.out.print("Nhập thiết bị thứ "+(i+1)+": ");
            String type = sc.next();

            if (type.equals("L")) {
                String id = sc.next();
                String name = sc.next();
                hub.addDevice(new SmartLight(id, name));
            }

            if (type.equals("AC")) {
                String id = sc.next();
                String name = sc.next();
                hub.addDevice(new AirConditioner(id, name));
            }

            if (type.equals("S")) {
                String id = sc.next();
                String name = sc.next();
                hub.addDevice(new SmartSpeaker(id, name));
            }

            if (type.equals("C")) {
                String id = sc.next();
                String name = sc.next();
                hub.addDevice(new SmartCurtain(id, name));
            }

        }

        System.out.println("==========Output==========");
        System.out.println("Turn Off All Devices: ");
        hub.turnOffAll();

        System.out.println();
        System.out.println("Setup Wifi:");
        hub.setupWifi();
    }
}