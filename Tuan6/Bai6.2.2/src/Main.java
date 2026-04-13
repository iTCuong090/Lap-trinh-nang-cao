public class Main {
    public static void main(String[] args) {
        Notifier emailNoti = new EmailNotifier();

        emailNoti.send("Hello world");

        Notifier facebookEmailNoti = new FacebookNotifier(emailNoti);
        facebookEmailNoti.send("Hello your mother");

        Notifier smsFacebookEmailNoti = new SMSNotifier(facebookEmailNoti);
        smsFacebookEmailNoti.send("Hello my dad");

    }
}