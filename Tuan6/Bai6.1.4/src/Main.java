import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Adapter ---");
        int[] arr = {5, 2, 9, 1, 5, 6};
        
        System.out.print("Original array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
        
        Sorter sorter = new NewSorter();
        int[] sortedArr = sorter.sort(arr);
        
        System.out.print("Sorted array: [");
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + (i < sortedArr.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("\n--- Prototype ---");
        ReportTemplate originalTemplate = new ReportTemplate(
                "Annual Report 2023",
                "Confidential",
                List.of("Introduction", "Financial Summary")
        );


        ReportTemplate clone1 = originalTemplate.clone();
        clone1.setTitle("Q1 Report 2024");
        clone1.addSection("Q1 Highlight");

        ReportTemplate clone2 = originalTemplate.clone();
        clone2.setTitle("Q2 Report 2024");
        clone2.addSection("Q2 Highlight");

        System.out.println("Original: " + originalTemplate);
        System.out.println("Clone 1: " + clone1);
        System.out.println("Clone 2: " + clone2);
    }
}
