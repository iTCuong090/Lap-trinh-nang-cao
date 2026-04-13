public class Main {
    public static void main(String[] args) {
        //Chọn app Email:
        NotificationApp emailApp = new EmailApp();
        emailApp.notifyUser("Hello, gửi = email nè");
        //Chọn app Sms:
        NotificationApp smsApp = new SMSApp();
        smsApp.notifyUser("Hello, gửi bằng sms nè");
    }
}