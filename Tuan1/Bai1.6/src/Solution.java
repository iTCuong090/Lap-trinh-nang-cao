public class Solution {
    public boolean isPrime(int n) {
        if (n<=1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution worker = new Solution();
        // --- NHÓM 1: CÁC SỐ ĐẶC BIỆT (Dễ sai nhất) ---
    System.out.println("Test -5 (Số âm):   " + worker.isPrime(-5));  // Mong đợi: false
    System.out.println("Test  0 (Số không): " + worker.isPrime(0));   // Mong đợi: false
    System.out.println("Test  1 (Số một):   " + worker.isPrime(1));   // Mong đợi: false
    System.out.println("Test  2 (Số nguyên tố chẵn): " + worker.isPrime(2)); // Mong đợi: true

    // --- NHÓM 2: SỐ NGUYÊN TỐ THỰC THỤ ---
    System.out.println("Test  3: " + worker.isPrime(3));     // Mong đợi: true
    System.out.println("Test 17: " + worker.isPrime(17));    // Mong đợi: true
    System.out.println("Test 97: " + worker.isPrime(97));    // Mong đợi: true

    // --- NHÓM 3: HỢP SỐ (Số không phải nguyên tố) ---
    System.out.println("Test  4: " + worker.isPrime(4));     // Mong đợi: false
    System.out.println("Test  9: " + worker.isPrime(9));     // Mong đợi: false
    System.out.println("Test 100: " + worker.isPrime(100));  // Mong đợi: false

    // --- NHÓM 4: SỐ LỚN (Kiểm tra hiệu năng) ---
    // Nếu hàm của bạn chạy quá lâu ở câu này thì cần tối ưu căn bậc hai
    System.out.println("Test 104729 (Số NT lớn): " + worker.isPrime(104729)); // Mong đợi: true
    System.out.println("Test 1000000 (Số triệu):  " + worker.isPrime(1000000)); // Mong đợi: false
    }
}