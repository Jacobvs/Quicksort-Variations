public class Insertion extends Sort{

    static void sort(Comparable[] a, int lo, int hi)
    { // Sort a[] into increasing order.
        for (int i = lo; i < hi; i++)
        { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

}
