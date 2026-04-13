public interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("Gửi bằng Email:"+msg);

    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier x) {
        this.notifier = x;
    }

    public abstract void send(String msg);
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier x) {
        super(x);
    }

    @Override
    public void send(String msg) {
        notifier.send(msg);
        System.out.println("Gửi bằng SMS: "+msg);
    }
}

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier x) {
        super(x);
    }

    @Override
    public void send(String msg) {
        notifier.send(msg);
        System.out.println("Gửi bằng Facebook: "+msg);
    }
}