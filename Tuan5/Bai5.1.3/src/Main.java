import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Đoạn văn bản mẫu giả lập
        String text = """
            Java is a high-level, class-based, object-oriented programming language that is 
            designed to have as few implementation dependencies as possible. It is a general-purpose 
            programming language intended to let programmers write once, run anywhere (WORA), 
            meaning that compiled Java code can run on all platforms that support Java without 
            the need to recompile. Java applications are typically compiled to bytecode that 
            can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. 
            
            The syntax of Java is similar to C and C++, but has fewer low-level facilities than 
            either of them. The Java runtime provides dynamic capabilities (such as reflection 
            and runtime code modification) that are typically not available in traditional 
            compiled languages. As of 2024, Java was one of the most popular programming 
            languages in use according to GitHub, particularly for client-server web applications, 
            with a reported 9 million developers.

            Java was originally developed by James Gosling at Sun Microsystems. It was released 
            in May 1995 as a core component of Sun Microsystems' Java platform. The original 
            and reference implementation Java compilers, virtual machines, and class libraries 
            were originally released by Sun under proprietary licenses. 
            
            Java is used in a wide variety of computing platforms from embedded devices and 
            mobile phones to enterprise servers and supercomputers. While less common on 
            desktop computers, Java applets were sometimes used to provide enhanced and 
            interactive features while browsing the web, although they have since been 
            deprecated for security reasons.
            """;

        // ---------------------------------------------------------
        // 1. CHUẨN HÓA VĂN BẢN
        // ---------------------------------------------------------
        // Chuyển toàn bộ thành chữ thường và loại bỏ tất cả dấu câu
        // Regex "[^a-z\\s]" nghĩa là: giữ lại chữ cái (a-z) và khoảng trắng (\\s), xóa mọi thứ khác ví dụ như dấu câu, emoji, vv.
        String normalizedText = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        
        // Tách chuỗi thành mảng các từ, phân cách bằng một hoặc nhiều khoảng trắng
        String[] words = normalizedText.split("\\s+");

        // ---------------------------------------------------------
        // 2. ĐẾM TỪ (Sử dụng HashMap)
        // ---------------------------------------------------------
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        
        for (String word : words) {
            // Bỏ qua các chuỗi rỗng phát sinh nếu có khoảng trắng thừa
            if (word.isEmpty()) {
                continue;
            }
            
            // Logic đếm từ theo yêu cầu
            if (!wordCountMap.containsKey(word)) {
                // Nếu từ chưa có trong Map thì thêm chữ đó vào và gán giá trị bằng 1 (đã xuất hiện 1 lần)
                wordCountMap.put(word, 1);
            } else {
                // Nếu từ đã có rồi, giá trị của từ đó trong map (số lần xuất hiện) + thêm 1.
                int oldValue = wordCountMap.get(word);
                wordCountMap.put(word, oldValue + 1);
            }
        }

        // ---------------------------------------------------------
        // 3. SẮP XẾP & THỐNG KÊ 
        // ---------------------------------------------------------
        String mostFrequentWord = "";
        int maxCount = 0;
        ArrayList<String> uniqueWords = new ArrayList<>();

        // Duyệt qua từng cặp (key - value) trong Map
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) { //Map.Entry<> là kiểu, là lớp của các key-value được lưu trong map.
            String word = entry.getKey();    //Phương thức .entrySet() của lớp Map trả về mảng của các đối tượng map.entry.
            int count = entry.getValue();

            // Cập nhật từ xuất hiện nhiều nhất
            if (count > maxCount) {
                maxCount = count;
                mostFrequentWord = word;
            }

            // Lọc các từ chỉ xuất hiện đúng 1 lần đưa vào List
            if (count == 1) {
                uniqueWords.add(word);
            }
        }

        // ---------------------------------------------------------
        // IN KẾT QUẢ
        // ---------------------------------------------------------
        System.out.println("TỪ XUẤT HIỆN NHIỀU NHẤT:");
        System.out.println("- '" + mostFrequentWord + "' với " + maxCount + " lần xuất hiện.\n");
        
        System.out.println("CÁC TỪ DUY NHẤT (UNIQUE WORDS - CHỈ XUẤT HIỆN 1 LẦN):");
        System.out.println("- Số lượng: " + uniqueWords.size() + " từ.");
        System.out.println("- Danh sách: " + uniqueWords);
    }
}