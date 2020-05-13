import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

abstract class Sort {

    private static int numExchanges = 0;
    private static int numCompares = 0;

    static boolean less(Comparable v, Comparable w) {
        numCompares++;
        return v.compareTo(w) < 0;
    }

    static void exch(Comparable[] a, int i, int j) {
        numExchanges++;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Getter
    static int getNumExchanges() {
        return numExchanges;
    }

    @Getter
    static int getNumCompares() {
        return numCompares;
    }

    @Setter
    static void resetCounts() {
        numExchanges = 0;
        numCompares = 0;
    }

    public static void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

}
