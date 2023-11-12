package com.atahanuz;

import java.util.Random;
import java.util.function.Consumer;

/**
 * This program benchmarks methods that sort arrays of integers.
 */
public class SortingBenchmark {

    private static boolean CHECK_SORTED = true;
    private static boolean RANDOMIZE = false;

    /**
     * Sets whether the benchmark should verify the sorted state of the array after sorting.
     *
     * @param checkSorted true to check if the array is sorted post sort, false to skip the check
     */
    public static void setCheckSorted(boolean checkSorted) {
        CHECK_SORTED = checkSorted;
    }

    /**
     * Sets whether the array to be sorted should be randomized.
     *
     * @param randomize true to generate a different random array each time, false to generate the same array
     */
    public static void setRandomize(boolean randomize) {
        RANDOMIZE = randomize;
    }

    /**
     * Benchmarks a sorting algorithm using a randomly generated array of integers.
     *
     * @param sorter the sorting method to be benchmarked
     * @param len the length of the random array to be generated and sorted
     * @return the time taken to sort the array in seconds
     */
    public static double sortingBenchmark(Consumer<int[]> sorter, int len){
        // Generate random array
        int[] array = null;
        if(!RANDOMIZE) {
            array = new Random(0).ints(len).toArray(); // Same random array every time
        } else {
            array = new Random().ints(len).toArray(); // Different random array every time
        }
        return sortAndBenchmark(sorter, array);
    }

    /**
     * Benchmarks a sorting algorithm using a provided array of integers.
     *
     * @param sorter the sorting method to be benchmarked
     * @param array the array to be sorted
     * @return the time taken to sort the array in seconds
     */
    public static double sortingBenchmark(Consumer<int[]> sorter, int[] array){
        return sortAndBenchmark(sorter, array);
    }

    /**
     * Sorts the given array using the provided sorting algorithm and benchmarks the time taken.
     *
     * @param sorter the sorting algorithm to be used
     * @param array the array to be sorted
     * @return the time taken to sort the array in seconds
     */
    private static double sortAndBenchmark(Consumer<int[]> sorter, int[] array) {
        long startTime = System.nanoTime();
        sorter.accept(array);
        if(CHECK_SORTED) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    System.out.println("NOT SORTED !!");
                    break;
                }
            }
        }
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e9;
        System.out.printf("Time= %.9f seconds%n", elapsedTime);
        return elapsedTime;
    }
      /*  EXAMPLE USAGE


        sortingBenchmark(Arrays::sort,100_000_000);
        sortingBenchmark(Arrays::parallelSort,100_000_000);

        int[] array= new int[]{4,2,6,3,9};
        sortingBenchmark(Arrays::sort,array);

         */

}
