public class Main {
    public static void main(String[] args) {
        Animal a = new Dog(); //Upcasting

        System.out.println("Trước khi sửa: \n");
        //Cat c = (Cat) a; //Downcasting   //Lỗi Runtime ép kiểu xuống vì tham chiếu a đang trỏ tới 1 con chó trong runtime.
        System.out.println("Exception in thread \"main\" java.lang.ClassCastException: class Dog cannot be cast to class Cat " +  
"(Dog and Cat are in unnamed module of loader 'app')\n  at Main.main(Main.java:4) \n");  
        System.out.println("Sau khi sửa: \n");
        if (a instanceof Cat) { //Nếu tham chiếu animal a thực sự trỏ đến một con mèo trong runtime thì downcast tham chiếu a thành kiểu con mèo.
            Cat c;
            c = (Cat) a;
            c.makeSound();          //Sau khi downcast thì trình trình biên dịch mới cho gọi các phương thức ở lớp mèo. Tuy nhiên vì
        }                           //phương thức này đc ghi đè rồi nên có liên kết động. Tham chiếu animal vẫn gọi được và kêu tiếng mèo
        else {                      //nếu tham chiếu thực sự trỏ vào con mèo ở runtime.
            System.out.println("Đây không phải Mèo!");
        }

    }
}

//Thực tế biên dịch được là bởi vì ban đầu tham chiếu a được khai báo kiểu là Animal nên Downcast hợp lệ, biên dịch thành công.

/* Lỗi runtime: Exception in thread "main" java.lang.ClassCastException: class Dog cannot be cast to class Cat (Dog and Cat are in unnamed module of loader 'app')
	at Main.main(Main.java:4)
 */

//Side note: Ép kiểu xuống thực chất là ép kiểu tham chiếu tới đối tượng chứ không phải ép kiểu của bản thân đối tượng. 