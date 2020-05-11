public class Insertion extends Sort{

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    static void sort(Comparable[] a, int lo, int hi)
    { // Sort a[] into increasing order.
        for (int i = lo; i < hi; i++)
        { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

}
