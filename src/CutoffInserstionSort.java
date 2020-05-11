public class CutoffInserstionSort extends QuickSort {


    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + 10) {
            Insertion.sort(a, lo, hi);
            return;
        }

        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

}
