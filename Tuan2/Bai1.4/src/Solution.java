public class Solution {
    public static long fibonacci(int n) {
        if (n<0) return -1;
        if (n<=1) return n;
        if (n>92) return Long.MAX_VALUE;
        long a = 0, b = 1, t = 0;
        for (int i = 2; i<=n; i++) {
            t=a+b;
            a=b;
            b=t;
        }
        return b;
    }
    public static void main(String[] args) {
        for (int i=0; i<=101; i++) {
            System.out.println("Fibonacci "+i+"="+fibonacci(i));
        }
    }
}