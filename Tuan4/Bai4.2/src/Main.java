public class Main {
    public static void main(String[] args) {
        Hero superman = new Hero();

        ((CanSwim) superman).swim();
        ((CanFight)superman).fight();
    }
}