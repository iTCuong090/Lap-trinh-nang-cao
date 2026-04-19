public class Task implements Runnable {
    private long durationMs;
    private String name;

    public Task(String name, long durationMs) {
        this.name = name;
        this.durationMs = durationMs;
    }

    @Override
    public void run() {
        System.out.println("Start "+name);
        try {
            Thread.sleep(durationMs);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        
        System.out.println("End "+name);
    }

}