import java.io.FileNotFoundException;

public class QuicksortVariations {


    public static void main(String[] args) throws FileNotFoundException {

        int N = 16384; // 2^14
        int T = 100;

        Double[] doubleData = DataGenerator.generateNDoubles(N);
        String[] stringData = DataGenerator.generateNStrings(N);
        Integer[] integerData = DataGenerator.generateNIntegers(N);
        Double[] doubles = doubleData;
        String[] strings = stringData;
        Integer[] ints = integerData;


        //Test Cutoff to Insertion QuickSort
        Stopwatch sw = new Stopwatch();
        TestingData insertionDoubles = new TestingData();
        TestingData insertionStrings = new TestingData();
        TestingData insertionInts = new TestingData();
        double lastTime = 0, currTime;
        for (int i = 0; i < T; i++) {
            CutoffInserstionSort.sort(doubles);
            currTime = sw.elapsedTime() - lastTime;
            insertionDoubles.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());
            lastTime = sw.elapsedTime();

            CutoffInserstionSort.sort(strings);
            currTime = sw.elapsedTime() - lastTime;
            insertionStrings.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());
            lastTime = sw.elapsedTime();

            CutoffInserstionSort.sort(ints);
            currTime = sw.elapsedTime() - lastTime;
            insertionInts.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());


            doubles = doubleData;
            strings = stringData;
            ints = integerData;
            lastTime = sw.elapsedTime();
        }

        System.out.println("Cutoff to Insertion QuickSort Testing data for " + T + " trials:");
        System.out.println("Doubles (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", insertionDoubles.getMinTime(), insertionDoubles.getMaxTime(), insertionDoubles.getAvgTime()));
        System.out.println("Doubles (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", insertionDoubles.getMinExch(), insertionDoubles.getMaxExch(), insertionDoubles.getAvgExch()));
        System.out.println("Doubles (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", insertionDoubles.getMinComps(), insertionDoubles.getMaxComps(), insertionDoubles.getAvgComps()));
        System.out.println();
        System.out.println("Strings (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", insertionStrings.getMinTime(), insertionStrings.getMaxTime(), insertionStrings.getAvgTime()));
        System.out.println("Strings (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", insertionStrings.getMinExch(), insertionStrings.getMaxExch(), insertionStrings.getAvgExch()));
        System.out.println("Strings (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", insertionStrings.getMinComps(), insertionStrings.getMaxComps(), insertionStrings.getAvgComps()));
        System.out.println();
        System.out.println("Ints (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", insertionInts.getMinTime(), insertionInts.getMaxTime(), insertionInts.getAvgTime()));
        System.out.println("Ints (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", insertionInts.getMinExch(), insertionInts.getMaxExch(), insertionInts.getAvgExch()));
        System.out.println("Ints (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", insertionInts.getMinComps(), insertionInts.getMaxComps(), insertionInts.getAvgComps()));
        System.out.println();
        System.out.println();

//
        //Test Three Way Partitioning QuickSort
        sw = new Stopwatch();
        TestingData threeWayDoubles = new TestingData();
        TestingData threeWayStrings = new TestingData();
        TestingData threeWayInts = new TestingData();
        lastTime = 0;
        for (int i = 0; i < T; i++) {
            ThreeWayPartitioning.sort(doubles);
            currTime = sw.elapsedTime() - lastTime;
            threeWayDoubles.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());
            lastTime = sw.elapsedTime();

            ThreeWayPartitioning.sort(strings);
            currTime = sw.elapsedTime() - lastTime;
            threeWayStrings.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());
            lastTime = sw.elapsedTime();

            ThreeWayPartitioning.sort(ints);
            currTime = sw.elapsedTime() - lastTime;
            threeWayInts.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());


            doubles = doubleData;
            strings = stringData;
            ints = integerData;
            lastTime = sw.elapsedTime();
        }

        System.out.println("Three Way Partitioning QuickSort Testing data for " + T + " trials:");
        System.out.println("Doubles (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", threeWayDoubles.getMinTime(), threeWayDoubles.getMaxTime(), threeWayDoubles.getAvgTime()));
        System.out.println("Doubles (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", threeWayDoubles.getMinExch(), threeWayDoubles.getMaxExch(), threeWayDoubles.getAvgExch()));
        System.out.println("Doubles (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", threeWayDoubles.getMinComps(), threeWayDoubles.getMaxComps(), threeWayDoubles.getAvgComps()));
        System.out.println();
        System.out.println("Strings (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", threeWayStrings.getMinTime(), threeWayStrings.getMaxTime(), threeWayStrings.getAvgTime()));
        System.out.println("Strings (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", threeWayStrings.getMinExch(), threeWayStrings.getMaxExch(), threeWayStrings.getAvgExch()));
        System.out.println("Strings (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", threeWayStrings.getMinComps(), threeWayStrings.getMaxComps(), threeWayStrings.getAvgComps()));
        System.out.println();
        System.out.println("Ints (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", threeWayInts.getMinTime(), threeWayInts.getMaxTime(), threeWayInts.getAvgTime()));
        System.out.println("Ints (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", threeWayInts.getMinExch(), threeWayInts.getMaxExch(), threeWayInts.getAvgExch()));
        System.out.println("Ints (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", threeWayInts.getMinComps(), threeWayInts.getMaxComps(), threeWayInts.getAvgComps()));
        System.out.println();
        System.out.println();


        //Test Median of Three Sort
        sw = new Stopwatch();
        TestingData medianThreeDoubles = new TestingData();
        TestingData medianThreeStrings = new TestingData();
        TestingData medianThreeInts = new TestingData();
        lastTime = 0;
        for (int i = 0; i < T; i++) {

            MedianOfThree.sort(doubles);
            currTime = sw.elapsedTime() - lastTime;
            medianThreeDoubles.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());
            lastTime = sw.elapsedTime();

            MedianOfThree.sort(strings);
            currTime = sw.elapsedTime() - lastTime;
            medianThreeStrings.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());
            lastTime = sw.elapsedTime();

            MedianOfThree.sort(ints);
            currTime = sw.elapsedTime() - lastTime;
            medianThreeInts.addAll(currTime, CutoffInserstionSort.getNumExchanges(), CutoffInserstionSort.getNumCompares());


            doubles = doubleData;
            strings = stringData;
            ints = integerData;
            lastTime = sw.elapsedTime();
        }

        System.out.println("Median of Three QuickSort Testing data for " + T + " trials:");
        System.out.println("Doubles (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", medianThreeDoubles.getMinTime(), medianThreeDoubles.getMaxTime(), medianThreeDoubles.getAvgTime()));
        System.out.println("Doubles (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", medianThreeDoubles.getMinExch(), medianThreeDoubles.getMaxExch(), medianThreeDoubles.getAvgExch()));
        System.out.println("Doubles (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", medianThreeDoubles.getMinComps(), medianThreeDoubles.getMaxComps(), medianThreeDoubles.getAvgComps()));
        System.out.println();
        System.out.println("Strings (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", medianThreeStrings.getMinTime(), medianThreeStrings.getMaxTime(), medianThreeStrings.getAvgTime()));
        System.out.println("Strings (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", medianThreeStrings.getMinExch(), medianThreeStrings.getMaxExch(), medianThreeStrings.getAvgExch()));
        System.out.println("Strings (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", medianThreeStrings.getMinComps(), medianThreeStrings.getMaxComps(), medianThreeStrings.getAvgComps()));
        System.out.println();
        System.out.println("Ints (Time):");
        System.out.println(String.format("Min: %.4f | Max: %.4f | Average: %.4f", medianThreeInts.getMinTime(), medianThreeInts.getMaxTime(), medianThreeInts.getAvgTime()));
        System.out.println("Ints (Exchanges):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", medianThreeInts.getMinExch(), medianThreeInts.getMaxExch(), medianThreeInts.getAvgExch()));
        System.out.println("Ints (Compares):");
        System.out.println(String.format("Min: %d | Max: %d | Average: %.4f", medianThreeInts.getMinComps(), medianThreeInts.getMaxComps(), medianThreeInts.getAvgComps()));
        System.out.println();
        System.out.println();
    }


}
