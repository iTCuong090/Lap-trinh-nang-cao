import java.util.ArrayList;
import java.util.List;

public abstract class Device {
    protected String id, name;
    protected boolean running;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        running = false;
    }

    public void turnOff() {
        running = false;
        System.out.println(name+" turned off");
    }

    public void turnOn() {
        running = true;
        System.out.println(name+" turned on");
    }
}

class SmartLight extends Device {
    protected int brightness;

    public SmartLight(String id, String name) {
        super(id, name);
        this.brightness = 0;
    }

}

interface ICanConnectToWifi {
    void connectToWifi();
}

class AirConditioner extends Device implements ICanConnectToWifi {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectToWifi() {
        System.out.println(name+" connected to wifi");
    }

}

class SmartSpeaker extends Device implements ICanConnectToWifi {
    protected int loudness;

    public SmartSpeaker(String id, String name) {
        super(id, name);
        this.loudness = 0;
    }

    public void connectToWifi() {
        System.out.println(name+" connected to wifi");
    }
}

class SmartCurtain extends Device {
    public SmartCurtain(String id, String name) {
        super(id, name);
    }
}

class Hub {
    protected ArrayList<Device> deviceList = new ArrayList<>();

    public void addDevice(Device d) {
        deviceList.add(d);
    }

    public void turnOnAll() {
        for (Device x: deviceList) {
            x.turnOn();
        }
    }

    public void turnOffAll() {
        for (Device x: deviceList) {
            x.turnOff();
        }
    }

    public void setupWifi() {
        for (Device x: deviceList) {
            if (x instanceof ICanConnectToWifi) {
                ((ICanConnectToWifi) x).connectToWifi();
                //Phải ép kiểu về IcanconnecttoWifi mới gọi đc hàm :(
            }
        }
    }
}