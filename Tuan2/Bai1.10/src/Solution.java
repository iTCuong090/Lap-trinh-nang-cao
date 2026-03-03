import java.util.Arrays;

public class Solution {
    public int secondLargest(int[] arr) {
        if (arr.length <2) return -1;
        int max=Integer.MIN_VALUE, second_max=Integer.MIN_VALUE;
        for (int i=0; i< arr.length; i++) {
            if (arr[i] > max) {
                max=arr[i];
            }
        }
        for (int i=0; i< arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        for (int i=0; i< arr.length; i++) {
            if (arr[i] > second_max) {
                second_max=arr[i];
            }
        }
        if (second_max == Integer.MIN_VALUE) return -1;
        return second_max;
    }
    
    public static void main(String[] args) {
        Solution worker = new Solution();
        // Khai báo các mảng test
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        int[] arr2 = {10, 10, 10};
        int[] arr3 = {50};
        int[] arr4 = {10, 5};
        int[] arr5 = {-1, -5, -10, -2};

        // In input và output trên cùng 1 dòng theo yêu cầu của bạn
        System.out.println("Input: " + Arrays.toString(arr1) + " | Output: " + worker.secondLargest(arr1));
        System.out.println("Input: " + Arrays.toString(arr2) + " | Output: " + worker.secondLargest(arr2));
        System.out.println("Input: " + Arrays.toString(arr3) + " | Output: " + worker.secondLargest(arr3));
        System.out.println("Input: " + Arrays.toString(arr4) + " | Output: " + worker.secondLargest(arr4));
        System.out.println("Input: " + Arrays.toString(arr5) + " | Output: " + worker.secondLargest(arr5));
    }
}