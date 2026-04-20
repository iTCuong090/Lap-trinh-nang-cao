public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int numThreads = 4;
        int incrementsPerThread = 10000;

        System.out.println("===== TEST 1: Su dung lock() =====");
        System.out.println("4 luong x 10000 lan tang = ky vong: 40000");

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < incrementsPerThread; j++) {
                        counter.increment();
                    }
                }
            }, "Thread-" + i);
            threads[i].start();
        }

        // Đợi tất cả luồng hoàn thành
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        System.out.println("Gia tri cuoi cung (lock): " + counter.getValue());

        // ===== TEST 2: tryLock() =====
        System.out.println("\n===== TEST 2: Su dung tryLock() =====");
        Counter counter2 = new Counter();

        /*
         * Mảng đếm số lần tryLock() thất bại cho mỗi luồng.
         * Dùng mảng int[] (1 phần tử) thay vì biến int thường
         * vì biến trong anonymous class phải là "effectively final".
         * Mảng là final (tham chiếu không đổi), nhưng nội dung bên trong có thể thay đổi.
         */
        int[] failedAttempts = new int[numThreads];

        Thread[] threads2 = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            threads2[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int localFails = 0;
                    int successCount = 0;
                    // Tiếp tục thử cho đến khi tăng được đúng 10000 lần
                    while (successCount < incrementsPerThread) {
                        if (counter2.tryIncrement()) {
                            successCount++;
                        } else {
                            localFails++;
                        }
                    }
                    failedAttempts[threadIndex] = localFails;
                }
            }, "TryLock-Thread-" + i);
            threads2[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads2[i].join();
        }

        System.out.println("Gia tri cuoi cung (tryLock): " + counter2.getValue());
        int totalFails = 0;
        for (int i = 0; i < numThreads; i++) {
            System.out.println("Thread " + i + ": so lan tryLock that bai = " + failedAttempts[i]);
            totalFails += failedAttempts[i];
        }
        System.out.println("Tong so lan tryLock that bai: " + totalFails);
    }
}
