public class Solution {
    public int sumOfDigits(int n) {
        if (n == Integer.MIN_VALUE) return 47;
        if (n<0) return sumOfDigits(n*(-1));
        int digit, result = 0;
        while (n>0) {
            digit = n%10;
            n=n/10;
            result=result+digit;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution worker = new Solution();
        System.out.println("--- Testing sumOfDigits ---");

        // 1. Số bằng 0
        System.out.println("Input: 0          => Output: " + worker.sumOfDigits(001));

        // 2. Số dương có 1 chữ số
        System.out.println("Input: 5          => Output: " + worker.sumOfDigits(5));

        // 3. Số dương có nhiều chữ số
        System.out.println("Input: 12345      => Output: " + worker.sumOfDigits(12345));
        long a = 30090000000;
        System.out.println(a);
        // 4. Số âm (Trường hợp bạn đã thử)
        System.out.println("Input: -12325367  => Output: " + worker.sumOfDigits(-12325367));

        // 5. Số âm có 1 chữ số
        System.out.println("Input: -9         => Output: " + worker.sumOfDigits(-9));

        // 6. Số lớn (Cận trên của kiểu int)
        System.out.println("Input: 2147483647 => Output: " + worker.sumOfDigits(2147483647));

        // 7. Số cực tiểu (Integer.MIN_VALUE)
        System.out.println("Input: -2147483648 => Output: " + worker.sumOfDigits(-2147483648));
    }
}