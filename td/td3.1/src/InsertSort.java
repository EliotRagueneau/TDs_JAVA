public class InsertSort implements SortAlgorithm {
    private static InsertSort instance;
    private InsertSort() {
    }

    public static InsertSort getInstance() {
        if (instance == null) {
            instance = new InsertSort();
        }
        return instance;
    }

    public String[] insertionSort(String[] unsorted) {
        String[] sorted = unsorted.clone();
        for (int i = 1; i < sorted.length; i++) {
            String current = sorted[i];
            int j = i - 1;
            while(j >= 0 && current.compareTo(sorted[j]) < 0) {
                sorted[j+1] = sorted[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            sorted[j+1] = current;
        }
        return sorted;
    }

    @Override
    public String[] sort(String[] unsorted) {
        String[] sorted = unsorted.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sorted[i].compareTo(sorted[j]) < 0) {
                    insertTillSrc(sorted, j, i);
                }
            }
        }
        return sorted;
    }

    private String[] insertTillSrc(String[] array, int posDest, int posSrc) {
        String tempIn = array[posDest];
        String tempOut;
        array[posDest] = array[posSrc];
        for (int i = posDest + 1; i <= posSrc; i++) {
            tempOut = array[i];
            array[i] = tempIn;
            tempIn = tempOut;
        }
        return array;
    }
}
