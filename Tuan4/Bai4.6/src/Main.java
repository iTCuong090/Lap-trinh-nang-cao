public class Main {
    public static void main(String[] args) {
        Integer[] a1 = new Integer[]{5,1,3,2};
        ArrayUtils.sort(a1);
        for (int i=0;i<a1.length;i++) {
            System.out.print(a1[i]+" ");
        }

        System.out.println();

        String[] a2 = new String[]{"C++","Java","Python"};
        ArrayUtils.sort(a2);
        for (int i=0;i<a2.length;i++) {
            System.out.print(a2[i]+" ");
        }
    }
}