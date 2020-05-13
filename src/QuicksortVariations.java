import java.io.*;
import java.nio.charset.StandardCharsets;

public class QuicksortVariations {


    public static void main(String[] args) throws FileNotFoundException {

        // Store all collected data in array for easy excel output
        // First dimension is test type where: 0 = Cutoff to Insertion Sort, 1 = Three Way Partitioning, 2 = Median Of Three
        // Second dimension is dataset type where: 0 = Doubles, 1 = Strings, 2 = Ints
        // Third dimension is N size where: 0 = 2^14, 1 = 2^15, 2 = 2^16, 3 = 2^17, 4 = 2^18
        // Fourth dimension is the data where: 0 = min, 1 = avg, 2 = max

        Double[][][][] timeData = new Double[3][3][5][3];
        Double[][][][] exchData = new Double[3][3][5][3];
        Double[][][][] compsData = new Double[3][3][5][3];

        // Toggle spammy output
        boolean printRich = true;
        boolean exportTxt = true;

        // Set number of trials
        int T = 100;

        for (int p = 14, c = 0; p <= 18; p++, c++) {

            int N = (int) Math.pow(2, p); // 2^p


            if(printRich) {
                System.out.println("===========================");
                System.out.println("N = 2^" + p + " (" + N + ")");
                System.out.println("===========================");
                System.out.println();
            }

            // Generate data
            Double[] doubleData = DataGenerator.generateNDoubles(N);
            String[] stringData = DataGenerator.generateNStrings(N);
            Integer[] integerData = DataGenerator.generateNIntegers(N);

            //Copy data to sort
            Double[] doubles = doubleData;
            String[] strings = stringData;
            Integer[] ints = integerData;


            //Test Cutoff to Insertion QuickSort for T trials
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

            // Save data in arrays
            timeData[0][0][c] = new Double[]{insertionDoubles.getMinTime(), insertionDoubles.getAvgTime(), insertionDoubles.getMaxTime()};
            exchData[0][0][c] = new Double[]{(double) insertionDoubles.getMinExch(), insertionDoubles.getAvgExch(), (double) insertionDoubles.getMaxExch()};
            compsData[0][0][c] = new Double[]{(double) insertionDoubles.getMinComps(), insertionDoubles.getAvgComps(), (double) insertionDoubles.getMaxComps()};
            timeData[0][1][c] = new Double[]{insertionStrings.getMinTime(), insertionStrings.getAvgTime(), insertionStrings.getMaxTime()};
            exchData[0][1][c] = new Double[]{(double) insertionStrings.getMinExch(), insertionStrings.getAvgExch(), (double) insertionStrings.getMaxExch()};
            compsData[0][1][c] = new Double[]{(double) insertionStrings.getMinComps(), insertionStrings.getAvgComps(), (double) insertionStrings.getMaxComps()};
            timeData[0][2][c] = new Double[]{insertionInts.getMinTime(), insertionInts.getAvgTime(), insertionInts.getMaxTime()};
            exchData[0][2][c] = new Double[]{(double) insertionInts.getMinExch(), insertionInts.getAvgExch(), (double) insertionInts.getMaxExch()};
            compsData[0][2][c] = new Double[]{(double) insertionInts.getMinComps(), insertionInts.getAvgComps(), (double) insertionInts.getMaxComps()};


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

            timeData[1][0][c] = new Double[]{threeWayDoubles.getMinTime(), threeWayDoubles.getAvgTime(), threeWayDoubles.getMaxTime()};
            exchData[1][0][c] = new Double[]{(double) threeWayDoubles.getMinExch(), threeWayDoubles.getAvgExch(), (double) threeWayDoubles.getMaxExch()};
            compsData[1][0][c] = new Double[]{(double) threeWayDoubles.getMinComps(), threeWayDoubles.getAvgComps(), (double) threeWayDoubles.getMaxComps()};
            timeData[1][1][c] = new Double[]{threeWayStrings.getMinTime(), threeWayStrings.getAvgTime(), threeWayStrings.getMaxTime()};
            exchData[1][1][c] = new Double[]{(double) threeWayStrings.getMinExch(), threeWayStrings.getAvgExch(), (double) threeWayStrings.getMaxExch()};
            compsData[1][1][c] = new Double[]{(double) threeWayStrings.getMinComps(), threeWayStrings.getAvgComps(), (double) threeWayStrings.getMaxComps()};
            timeData[1][2][c] = new Double[]{threeWayInts.getMinTime(), threeWayInts.getAvgTime(), threeWayInts.getMaxTime()};
            exchData[1][2][c] = new Double[]{(double) threeWayInts.getMinExch(), threeWayInts.getAvgExch(), (double) threeWayInts.getMaxExch()};
            compsData[1][2][c] = new Double[]{(double) threeWayInts.getMinComps(), threeWayInts.getAvgComps(), (double) threeWayInts.getMaxComps()};



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

            timeData[2][0][c] = new Double[]{medianThreeDoubles.getMinTime(), medianThreeDoubles.getAvgTime(), medianThreeDoubles.getMaxTime()};
            exchData[2][0][c] = new Double[]{(double) medianThreeDoubles.getMinExch(), medianThreeDoubles.getAvgExch(), (double) medianThreeDoubles.getMaxExch()};
            compsData[2][0][c] = new Double[]{(double) medianThreeDoubles.getMinComps(), medianThreeDoubles.getAvgComps(), (double) medianThreeDoubles.getMaxComps()};
            timeData[2][1][c] = new Double[]{medianThreeStrings.getMinTime(), medianThreeStrings.getAvgTime(), medianThreeStrings.getMaxTime()};
            exchData[2][1][c] = new Double[]{(double) medianThreeStrings.getMinExch(), medianThreeStrings.getAvgExch(), (double) medianThreeStrings.getMaxExch()};
            compsData[2][1][c] = new Double[]{(double) medianThreeStrings.getMinComps(), medianThreeStrings.getAvgComps(), (double) medianThreeStrings.getMaxComps()};
            timeData[2][2][c] = new Double[]{medianThreeInts.getMinTime(), medianThreeInts.getAvgTime(), medianThreeInts.getMaxTime()};
            exchData[2][2][c] = new Double[]{(double) medianThreeInts.getMinExch(), medianThreeInts.getAvgExch(), (double) medianThreeInts.getMaxExch()};
            compsData[2][2][c] = new Double[]{(double) medianThreeInts.getMinComps(), medianThreeInts.getAvgComps(), (double) medianThreeInts.getMaxComps()};

            if(printRich){
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

        if(exportTxt) {
            String str = "Time Data:\n";
            str = str + dataExporter(timeData);
            str = str + "Exchange Data:\n";
            str = str + dataExporter(exchData);
            str = str + "Comparisons Data:\n";
            str = str + dataExporter(compsData);

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
                writer.write(str);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // Prints data in CSV format for import to excel
    private static String dataExporter(Double[][][][] data){
        StringBuilder str = new StringBuilder();
        for(Double[][][] a : data){ // print type of sort
            for(Double[][] b : a){ // Print doubles/strings/ints
                for(Double[] v : b){ // Print n's
                    str.append(v[0]).append(", ").append(v[1]).append(", ").append(v[2]).append("\n");
                }
            }
        }
        str.append("\n-----\n");
        return str.toString();
    }

}
