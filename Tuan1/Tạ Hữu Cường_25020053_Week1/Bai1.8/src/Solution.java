public class Solution {
    public static int reverse(int n) {
        if (n == Integer.MIN_VALUE) return 0;
        if (n<0) return reverse(Math.abs(n))*(-1);
        String s = Integer.toString(n);
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        int j=0;
        for (int i=a.length-1; i>=0; i--) {
            b[j]=a[i];
            j++;
        }
        String c = String.valueOf(b);
        int result=0;
        try {
            result = Integer.parseInt(c);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public boolean isPalindrome(int n) {
        if (reverse(n)==n) {
            return true;
        }
        else 
            return false;
    }

    public static void main(String[] args) {
        Solution worker = new Solution();
        System.out.println("--- Test Case Palindrome Hợp Lệ ---");
        System.out.println("Số lẻ chữ số (121): " + worker.isPalindrome(121));   // true
        System.out.println("Số chẵn chữ số (1221): " + worker.isPalindrome(1221)); // true
        System.out.println("Số có 1 chữ số (7): " + worker.isPalindrome(7));     // true

        System.out.println("\n--- Test Case Không Phải Palindrome ---");
        System.out.println("Số bình thường (123): " + worker.isPalindrome(123));   // false
        System.out.println("Số có số 0 ở cuối (10): " + worker.isPalindrome(10));  // false

        System.out.println("\n--- Test Case Số Âm (Luôn false) ---");
        System.out.println("Số âm đối xứng (-121): " + worker.isPalindrome(-121)); // false
        System.out.println("Số âm nhỏ nhất (Min Int): " + worker.isPalindrome(Integer.MIN_VALUE)); // false

        System.out.println("\n--- Test Case Số Lớn/Đặc Biệt ---");
        // 1,199,999,911 là số Palindrome nhưng khi đảo ngược có thể gây tràn int
        // Tuy nhiên, vì n < 2.1 tỷ nên n vẫn là int hợp lệ. 
        // Nếu reverse(n) trả về 0 do tràn, phép so sánh sẽ trả về false (hợp lý).
        System.out.println("Số lớn đối xứng (1199999911): " + worker.isPalindrome(1199999911)); 
        System.out.println("Số lớn không đối xứng (2147483647): " + worker.isPalindrome(2147483647));
}
}