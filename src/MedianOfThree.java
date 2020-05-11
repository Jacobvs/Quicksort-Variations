public class MedianOfThree extends QuickSort{

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        int middle = (lo + hi) / 2;

        if(less(a[middle], a[lo]))
            exch(a, lo, middle );
        if(less(a[hi], a[lo]))
            exch( a, lo, hi);
        if(less(a[lo], a[middle]))
            exch(a, middle, hi);

        exch(a, middle, hi - 1);

        int j = partition(a, lo, hi);
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }
}
