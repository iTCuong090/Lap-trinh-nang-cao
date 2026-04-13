public interface Notification {
    void send(String msg);
}

class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Đã gửi tin nhắn Email: " + msg);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Đã gửi tin nhắn SMS: " + msg);
    }

}

abstract class NotificationApp {
    public void notifyUser(String msg) {
        Notification noti = createNotification();
        noti.send(msg);
    }

    public abstract Notification createNotification();
}

class EmailApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}