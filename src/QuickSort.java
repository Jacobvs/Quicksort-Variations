public class QuickSort extends Sort {

    /**
     * Base quicksort implementation
     * @param a Comparable[] of values
     */
    public static void sort(Comparable[] a) {
        resetCounts();
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    /**
     * Helper method to recurse upon
     * @param a Comparable[] of values
     * @param lo lower bound
     * @param hi upper bound
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    /**
     * Sorts sub-arrays
     * @param a Comparable[] of values
     * @param lo lower bound
     * @param hi upper bound
     */
    static int partition(Comparable[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        return partition(a, a[lo], lo, hi);
    }

    static int partition(Comparable[] a, Comparable v, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

}
