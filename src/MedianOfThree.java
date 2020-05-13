public class MedianOfThree extends QuickSort {

    public static void sort(Comparable[] a) {
        resetCounts();
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int middle = medianOfThree(a, lo, hi);
        exch(a, middle, lo);

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int medianOfThree(Comparable[] a, int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        return (less(a[lo], a[mid]) ?
                (less(a[mid], a[hi]) ?
                        mid
                        : less(a[lo], a[hi]) ?
                        hi : lo)
                : (less(a[hi], a[mid]) ?
                mid
                : less(a[hi], a[lo]) ?
                hi : lo));
    }
}
