public class Main {
    public static void swap(NumberWrapper a, NumberWrapper b) {
        NumberWrapper temp;
        temp=a;
        a=b;
        b=temp;
    }
    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);
        System.out.println("Before:");
        System.out.println(n1.getValue());
        System.out.println(n2.getValue());
        swap(n1,n2);
        System.out.println("After:");
        System.out.println(n1.getValue());
        System.out.println(n2.getValue());
    }
}