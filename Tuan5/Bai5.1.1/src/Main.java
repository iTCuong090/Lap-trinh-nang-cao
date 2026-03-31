public class Main {
    public static void main(String[] args) {
        System.out.println("Thực thi hàm useString:");
        measureExecutionTime(() -> {useString();});
        System.out.println("Thực thi hàm useStringBuffer:");
        measureExecutionTime(() -> {useStringBuffer();});
        contentAnalysis("Em yêu Java. Em ghét Python. Em có yêu Java không? Đừng có yêu!");

    }

    // Hàm nhận vào một "hành động" dưới dạng lambda expression và đo thời gian
    public static void measureExecutionTime(Runnable task) {
        long startTime = System.nanoTime(); // Dùng nanoTime để chính xác hơn
        
        task.run(); // Chạy hàm được truyền vào
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Đổi sang miliseconds
        System.out.println("Thời gian thực thi: " + duration + " ms");
    }

    public static void useString() {
        String s = "";
        for (int i=0;i<100000;i++) {
            s=s+"Hello";
        }
    }

    public static void useStringBuffer() {
        StringBuffer s = new StringBuffer("");
        for (int i=0; i<100000;i++) {
            s.append("Hello");
        }
    }

    public static void contentAnalysis(String inputString) {
        System.out.println("Phân tích String: "+inputString);
        System.out.println("Số câu: "+countDot(inputString));
        System.out.println("Sau khi thay thế Java bằng Python: "+inputString.replace("Java","Python"));
    }

    public static int countDot(String s) {
        int count=0;
        for (int i=0; i<s.length(); i++) {
            if ((s.charAt(i) == '.') || (s.charAt(i) == '?') || (s.charAt(i) == '!')) {
                count+=1;
            }
        }
        return count;
    }
}