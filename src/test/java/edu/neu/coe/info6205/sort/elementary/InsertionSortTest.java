package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest {

    private static final int UPPER_BOUND = (int)Math.pow(2,14);
    private static final int n = 10;

    public static double benchmark(String description, final Integer[] arr) {

        Benchmark<Integer[]> benchmarkTimer = new Benchmark_Timer<>(description, x ->
            x.clone(),
            input_arr -> new InsertionSort<Integer>().sort(input_arr,0,input_arr.length), null
        );

        return benchmarkTimer.run(arr, n);
    }

    public static void main(String[] args) {

        List<Double> timings = new ArrayList<>();

        //Input array as Reverse Ordered
        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrayFactory af = new ArrayFactory(i);
            Integer[] arr = af.getDecreasing(); timings.add(benchmark("Reverse-Ordered", arr.clone()));
        }

        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Size of Array: " + i + " -> " + timings.get(j));
        }

        //Input array as Partially Ordered
        timings = new ArrayList<>();

        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrayFactory af = new ArrayFactory(i);
            Integer[] arr = af.getPartial(); timings.add(benchmark("Partially-Ordered", arr.clone()));
        }

        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Size of Array: " + i + " -> " + timings.get(j));
        }

        //Input array as Sorted Array
        timings = new ArrayList<>();

        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrayFactory af = new ArrayFactory(i);
            Integer[] arr = af.getIncreasing(); timings.add(benchmark("Increasing-Ordered", arr.clone()));
        }

        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Size of Array: " + i + " -> " + timings.get(j));
        }

        //Input array as Random Numbers

        timings = new ArrayList<>();
        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrayFactory af = new ArrayFactory(i);

            Integer[] arr = af.getRandom(); timings.add(benchmark("Random-Ordered", arr.clone()));
        }

        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Size of Array: " + i + " -> " + timings.get(j));
        }
    }
}