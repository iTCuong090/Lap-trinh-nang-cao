import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordMap;

    public WordCounter() {
        this.wordMap = new HashMap<>();
    }

    // B1 & B2: Chuẩn hóa và tách chuỗi
    public void analyze(String text) {
        if (text == null || text.isEmpty()) return;

        // Chuẩn hóa: Chuyển về chữ thường và xóa các dấu câu (. , ! ? ...)
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
        
        // Tách chuỗi thành mảng các từ dựa trên khoảng trắng.
        // "\\s+" bao gồm "\s" có nghĩa là bất kì loại kí tự khoảng trắng nào (tab, xuống dòng, vv), + có nghĩa là từ 1 trở lên, \ là kí tự thoát"
        String[] words = cleanText.split("\\s+");

        // B3: Duyệt mảng và đưa vào HashMap
        for (String word : words) {
            if (word.isEmpty()) continue;

            if (wordMap.containsKey(word)) {
                // Nếu từ đã có: Lấy giá trị cũ + 1
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                // Nếu từ chưa có: Đặt giá trị là 1
                wordMap.put(word, 1);
            }
        }
    }

    // Hiển thị kết quả
    public void displayResult() {
        System.out.println("--- Thống kê tần suất từ ---");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Tìm từ xuất hiện nhiều nhất
    public void findMostFrequentWord() {
        String mostFrequent = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        if (mostFrequent != null) {
            System.out.println("\n=> Từ khóa chính: '" + mostFrequent + "' với " + maxCount + " lần xuất hiện.");
        }
    }


}