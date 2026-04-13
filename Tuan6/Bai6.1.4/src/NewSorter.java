public class NewSorter implements Sorter {
    private SorterAdapter legacySorter = new SorterAdapter();

    @Override
    public int[] sort(int[] arr) {
        return legacySorter.sort(arr);

    }
}