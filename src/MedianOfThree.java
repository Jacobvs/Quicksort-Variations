public class MedianOfThree extends QuickSort {

    public static void sort(Comparable[] a) {
        resetCounts(); // Reset previous counts
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int middle = medianOfThree(a, lo, hi); // Get median
        exch(a, middle, lo); // Swap median and low so partition will pivot off it

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int medianOfThree(Comparable[] a, int lo, int hi) {
        int mid = (lo + hi) >>> 1;        // Get middle
        return (less(a[lo], a[mid]) ?           // If lo < mid
                (less(a[mid], a[hi]) ?              // If mid < hi
                        mid                             // Return Mid
                        : less(a[lo], a[hi]) ?      // Else if  lo < hi
                        hi : lo)                        // Return hi

                : (less(a[hi], a[mid]) ?       // Else if hi < mid
                mid                                // Return mid
                : less(a[hi], a[lo]) ?         // Else if hi < lo
                hi : lo));                         // Return hi
    }                                          // Else return lo
}
