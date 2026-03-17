public class Main {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[4];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();

        for (int i=0; i<zoo.length; i++) {
            zoo[i].makeSound();
        }
    }
}

//Con vịt kêu Animals sound vì không được ghi đè phương thức riêng của nó mà sử dụng phương thức makeSound từ lớp Animal.