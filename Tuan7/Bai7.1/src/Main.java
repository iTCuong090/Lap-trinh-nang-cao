public class Main {
    public static void main(String[] agrs) throws InterruptedException {
        Task task1 = new Task("task1",200);
        Task task2 = new Task("task2",200);
        Thread thread2 = new Thread(task1);
        Thread thread1 = new Thread(task2);
        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();
        System.out.println("All tasks done.");


    }
}