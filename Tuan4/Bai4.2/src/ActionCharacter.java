interface CanFly {
    void fly();    
}

interface CanSwim {
    void swim();
}

interface CanFight {
    void fight();
}

public class ActionCharacter {
    public void fight() {
        System.out.println("Đấm bốc...");
    }
}

class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {
    public void swim() {
        System.out.println("Hero is swimming...");
    }
    public void fly() {
        System.out.println("Hero is flying...");
    }
}