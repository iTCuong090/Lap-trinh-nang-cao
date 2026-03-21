public abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public void ChargeBattery() {
        batteryLevel = 100;
    }

    public final void showIdentity() {
        System.out.println("A robot is showing its property: ");
        System.out.println("ID: "+id+" Model: "+modelName);
    }

    public String getModelName() {
        return modelName;
    }

    public abstract void performMainTask();
}

interface Flyable {
    void Fly();
}

interface Swimmable {
    void Swim();
}

interface GPS {
    void getCoordinates();
}

class DroneRobot extends Robot implements Flyable, GPS {
    @Override
    public void Fly() {
        System.out.println(this.getModelName()+" flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(this.getModelName()+" getting coordinates");
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getModelName()+" performing main task");
        Fly();
        getCoordinates();
    }

    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }
}

class FishRobot extends Robot implements Swimmable {
    @Override
    public void Swim() {
        System.out.println(this.getModelName()+" swimming");
    }
    @Override
    public void performMainTask() {
        System.out.println(this.getModelName()+" performing main task");
        Swim();
    }

    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    @Override
    public void Fly() {
        System.out.println(this.getModelName()+" flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(this.getModelName()+" getting coordinates");
    }

    @Override
    public void Swim() {
        System.out.println(this.getModelName()+" swimming");
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getModelName()+" performing main task");
        Fly();
        Swim();
        getCoordinates();
    }

    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }
}