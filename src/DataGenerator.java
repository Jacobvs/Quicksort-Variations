import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataGenerator {

    public static Double[] generateNDoubles(int n) {
        Double[] arr = new Double[n];
        for (int i = 0; i < n; i++)
            arr[i] = StdRandom.uniform();
        return arr;
    }

    public static String[] generateNStrings(int n) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<>();
        String[] res = new String[n];
        Scanner sc = new Scanner(new File("words.english.txt"));
        while (sc.hasNext()) {
            String s = sc.next();
            strings.add(s);
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            int index = StdRandom.uniform(0, strings.size());
            res[i] = strings.remove(index);
        }
        return res;
    }

    public static Integer[] generateNIntegers(int n) {
        Integer[] ints = new Integer[n * 15];
        int count = 0;
        for (int i = 2; i < 17; i++) {
            for (int j = 0; j < n; j++) {
                ints[count] = StdRandom.uniform(0, n / i);
                count++;
            }
        }
        return ints;
    }

}
