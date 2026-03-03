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

    public static void main(String[] args) {
        Solution worker = new Solution();
        System.out.println("--- Test Case Cơ Bản ---");
        System.out.println("Số dương bình thường (123): " + worker.reverse(123)); // Kỳ vọng: 321
        System.out.println("Số âm bình thường (-456): " + worker.reverse(-456)); // Kỳ vọng: -654

        System.out.println("\n--- Test Case Số 0 ---");
        System.out.println("Số có chữ số 0 ở cuối (120): " + worker.reverse(120)); // Kỳ vọng: 21
        System.out.println("Số 0: " + worker.reverse(0)); // Kỳ vọng: 0

        System.out.println("\n--- Test Case Tràn Số (Overflow) ---");
        // Số này đảo ngược sẽ là 9,999,999,911 > 2,147,483,647
        System.out.println("Số dương lớn gây tràn (1199999999): " + worker.reverse(1199999999)); // Kỳ vọng: 0
        // Số này đảo ngược sẽ là -9,474,836,412 < -2,147,483,648
        System.out.println("Số âm lớn gây tràn (-2147483649...): " + worker.reverse(-2143847419)); // Kỳ vọng: 0

        System.out.println("\n--- Test Case Cận Biên (Boundaries) ---");
        System.out.println("Max Int (2147483647): " + worker.reverse(2147483647)); // Kỳ vọng: 0 (vì đảo ngược chắc chắn tràn)
        System.out.println("Min Int (-2147483648): " + worker.reverse(-2147483648)); // Kỳ vọng: 0
    }
}