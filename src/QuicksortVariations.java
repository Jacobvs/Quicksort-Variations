import java.io.FileNotFoundException;

public class QuicksortVariations{

    public static void main(String[] args) throws FileNotFoundException{

        int N = 16384; // 2^14
        Double[] doubleData = DataGenerator.generateNDoubles(N);
        String[] stringData = DataGenerator.generateNStrings(N);
        Integer[] integerData = DataGenerator.generateNIntegers(N);

        int T = 100; // 100 Trials
        int exchangeLow = Integer.MAX_VALUE, exchangeHigh = 0, compareLow = Integer.MAX_VALUE, compareHigh = 0;
        double lastTime = 0, timeLow = Double.MAX_VALUE, timeAvg = 0, timeHigh = 0, exchangeAvg = 0, compareAvg = 0;

        Stopwatch sw = new Stopwatch();
        CutoffInserstionSort.sort(doubleData);
        System.out.println(sw.elapsedTime());
        System.out.println(CutoffInserstionSort.getNumCompares());
        System.out.println(CutoffInserstionSort.getNumExchanges());

//        //Test Cutoff to Insertion Sort
//        Stopwatch sw = new Stopwatch();
//        for (int i = 0; i < T; i++) {
//            Double[] doubles = doubleData;
//            CutoffInserstionSort.sort(doubles);
//            doubles = doubleData;
//            CutoffInserstionSort.sort(doubles);
//
//
//        }

    }



}
