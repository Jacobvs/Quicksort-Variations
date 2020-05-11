import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataGenerator {


    public ArrayList<Double> generateNDoubles(int n){
        ArrayList<Double> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(StdRandom.uniform());

        return arr;
    }

    public ArrayList<String> generateNStrings(int n) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        Scanner sc = new Scanner(new File("words.english.txt"));
        while (sc.hasNext()) {
            String s = sc.next();
            strings.add(s);
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            int index = StdRandom.uniform(0, strings.size());
            res.add(strings.remove(index));
        }
        return res;
    }

    public ArrayList<Integer> generateNIntegers(int n){
        ArrayList<Integer> ints = new ArrayList<>();

        for (int i = 2; i < 17; i++)
            for (int j = 0; j < n; j++)
                ints.add(StdRandom.uniform(n/i));

        return ints;
    }

}
