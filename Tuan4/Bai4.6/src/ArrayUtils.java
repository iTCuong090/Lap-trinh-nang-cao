public class ArrayUtils {
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        for (int i=n-1; i>=0; i--) {
            boolean swapped = false;
            for (int j=0; j<=i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) { //Vì đã yêu cầu T extends Comparable nên chắc chắn có thể gọi method compareTo()
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}