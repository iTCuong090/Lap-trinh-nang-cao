public class SorterAdapter {
    private LegacySorter legacySorter;

    public SorterAdapter() {
        this.legacySorter = new LegacySorter();
    }

    public int[] sort(int[] arr) {
        return legacySorter.quickSort(arr);
    }
}
