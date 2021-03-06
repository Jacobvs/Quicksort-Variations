import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.Collections;

public class TestingData {

    private ArrayList<Double> times;
    private ArrayList<Integer> exchanges, compares;

    /**
     * Stores data from trials for easy access
     */
    public TestingData() {
        this.times = new ArrayList<>();
        this.exchanges = new ArrayList<>();
        this.compares = new ArrayList<>();
    }

    /**
     *
     * @param time double of execution time
     * @param exchanges int of exchanges made while sorting
     * @param compares int of compares made while sorting
     */
    @Setter
    public void addAll(double time, int exchanges, int compares) {
        this.times.add(time);
        this.exchanges.add(exchanges);
        this.compares.add(compares);
    }

    @Getter
    public double getMaxTime() {
        return Collections.max(times);
    }

    @Getter
    public double getMinTime() {
        return Collections.min(times);
    }


    @Getter
    public double getAvgTime() {
        // Use java streams to simplify this
        return times.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    @Getter
    public int getMaxExch() {
        return Collections.max(exchanges);
    }

    @Getter
    public int getMinExch() {
        return Collections.min(exchanges);
    }

    @Getter
    public double getAvgExch() {
        return exchanges.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    @Getter
    public int getMaxComps() {
        return Collections.max(compares);
    }

    @Getter
    public int getMinComps() {
        return Collections.min(compares);
    }

    @Getter
    public double getAvgComps() {
        return compares.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }
}
