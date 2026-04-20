import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

/*
 * ===== Ý ĐỒ CỦA ĐỀ BÀI =====
 * Bài này giúp sinh viên:
 * 1. Rèn luyện kỹ năng chia công việc cho nhiều luồng chạy song song.
 * 2. Xử lý ngoại lệ trong Callable (trả về null khi mảng không hợp lệ).
 * 3. Thuật toán tìm số lớn thứ hai (second largest) trong mảng.
 * 4. Kỹ thuật dùng Future.get() để tổng hợp kết quả từ nhiều luồng.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số mảng
        System.out.print("Nhap so mang n: ");
        int n = scanner.nextInt();

        // Đọc từng mảng
        int[][] arrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            arrays[i] = new int[size];
            for (int j = 0; j < size; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(n);

        /*
         * [KIẾN THỨC] Integer (wrapper class) vs int (primitive)
         * - Callable<Integer> yêu cầu kiểu wrapper vì generic không nhận kiểu nguyên thủy.
         * - Integer có thể là null, int thì không → dùng null để đánh dấu "không tìm thấy".
         * 
         * Vì sao dùng Integer thay vì int?
         * - Callable<int> sẽ LỖI BIÊN DỊCH vì generic chỉ nhận kiểu object.
         * - Cần trả về null khi mảng không có số lớn thứ hai → int không thể null.
         */
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

        for (int i = 0; i < n; i++) {
            final int index = i;
            final int[] arr = arrays[i];

            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() {
                    return findSecondLargest(arr);
                }
            };

            futures.add(executor.submit(task));
        }

        // Tổng hợp kết quả
        long sum = 0;
        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer result = futures.get(i).get();
                if (result != null) {
                    System.out.println("Array " + i + ": second largest = " + result);
                    sum += result;
                } else {
                    System.out.println("Array " + i + ": Not found");
                }
            } catch (Exception e) {
                System.out.println("Array " + i + ": Loi - " + e.getMessage());
            }
        }

        System.out.println("Sum = " + sum);
        executor.shutdown();
        scanner.close();
    }

    /**
     * Tìm số lớn thứ hai trong mảng.
     * Trả về null nếu không tìm được (mảng < 2 phần tử hoặc tất cả bằng nhau).
     * 
     * [THUẬT TOÁN]
     * - Duyệt mảng 1 lần, duy trì 2 biến: max (lớn nhất) và secondMax (lớn nhì).
     * - Nếu gặp giá trị > max: secondMax = max, max = giá trị mới.
     * - Nếu gặp giá trị > secondMax VÀ < max: secondMax = giá trị mới.
     * - Nếu cuối cùng secondMax vẫn là Integer.MIN_VALUE → không tìm thấy.
     */
    public static Integer findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            return null;
        }

        /*
         * [KIẾN THỨC] Integer.MIN_VALUE
         * - Là giá trị nhỏ nhất mà int có thể lưu (-2,147,483,648).
         * - Dùng làm giá trị khởi tạo để bất kỳ phần tử nào cũng lớn hơn.
         */
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        // Nếu secondMax không đổi → không có số lớn thứ 2 hợp lệ
        if (secondMax == Integer.MIN_VALUE) {
            return null;
        }
        return secondMax;
    }
}
