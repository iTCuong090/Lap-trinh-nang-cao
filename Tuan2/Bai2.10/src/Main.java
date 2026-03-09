public class Main {
    public static void main(String[] args) {

        CentralHub hub = new CentralHub();


        SmartLight l1 = new SmartLight("L01", "Đèn phòng khách", 80);

        SmartLight l2 = new SmartLight("L02", "Đèn ngủ");

        l2.setBrightness("ECO");

        l1.connectToHub(hub);
        l2.connectToHub(hub);

        System.out.println("Kết quả kiểm tra độ sáng: ");
        System.out.println("Đèn l1 (" + l1.getName() + "): " + l1.getBrightness() + "%");
        System.out.println("Đèn l2 (" + l2.getName() + "): " + l2.getBrightness() + "%");
    }
}