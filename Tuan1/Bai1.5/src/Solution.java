public class Solution {
    public int gcd(long a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a==0) return b;
        if (b==0) return a;
        for (long i = a; i>=1; i--) {
            if (a%i==0 && b%i==0) return i;
        }
        return 1;
    }
    public static void main(String[] args) {
        Solution worker = new Solution();
        System.out.println(worker.gcd(30, 15));
        System.out.println("Test 1 (30, 15): " + worker.gcd(30, 15));    // Mong đợi: 15
        System.out.println("Test 2 (12, 18): " + worker.gcd(12, 18));    // Mong đợi: 6
        System.out.println("Test 3 (17, 13): " + worker.gcd(17, 13));    // Mong đợi: 1
        System.out.println("Test 4 (20, 20): " + worker.gcd(20, 20));    // Mong đợi: 20

        System.out.println("Test 5 (0, 5):   " + worker.gcd(0, 5));     
        System.out.println("Test 6 (-10, 5): " + worker.gcd(-10, 5));
    }
}