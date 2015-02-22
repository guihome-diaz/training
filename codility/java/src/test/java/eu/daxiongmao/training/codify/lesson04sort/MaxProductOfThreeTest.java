package eu.daxiongmao.training.codify.lesson04sort;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaxProductOfThreeTest {


    @Test
    public void maxProductExample() {
        final Integer[] unorderedArray = new Integer[] {-3, 1, 2, -2, 5, 6};
        final int expectedResult = 2 * 5 * 6;

        // Algo to test
        final MaxProductOfThree algo = new MaxProductOfThree();
        final int computedResult = algo.solutionUsingPersonalMergeSort(unorderedArray);

        Assert.assertEquals(expectedResult, computedResult);
    }

    @Test
    public void maxProductBasic() {
        final Integer[] unorderedArray = new Integer[] {5, 2, 8, 8000, 1182, 82, -4000, 6000, 2, 14, -1, 1, 16, 4, -9, 1};
        final int expectedResult = 8000 * 6000 * 1182;

        // Algo to test
        final MaxProductOfThree algo = new MaxProductOfThree();
        final int computedResult = algo.solutionUsingPersonalMergeSort(unorderedArray);

        Assert.assertEquals(expectedResult, computedResult);
    }


    @Test
    public void maxProductWithNegativeNumbers() {
        final Integer[] unorderedArray = new Integer[] {5, 2, 8, -7000, -6500, 8000, 1182, 82, -4000, 6000, 2, 14, -1, 1, 16, 4, -9, 1};
        final Integer expectedResult = Math.abs(-7000 * -6500 * 8000);

        // Algo to test
        final MaxProductOfThree algo = new MaxProductOfThree();
        final Integer computedResult = algo.solutionUsingPersonalMergeSort(unorderedArray);

        Assert.assertEquals(expectedResult, computedResult);
    }

    @Ignore
    @Test
    public void performanceComparison() {
        // !!! Like in JavaScript, comparisons needs to be done many times to ensure there success !!

        int arraySize = 100000;
        int comparisonRun = 100;
        System.out.println("Sorting and computing result over " + arraySize + " items, " + comparisonRun + " times");
        final MaxProductOfThree algo = new MaxProductOfThree();

        long mergeAlgoTimeInMs = 0;
        long javaAlgoTimeInMs = 0;

        System.out.print("please wait...");
        for (int i = 0; i < comparisonRun; i++) {
            System.out.print(" .");
            // Generate random values
            final Integer[] unorderedArray = new Integer[arraySize];
            Random random = new Random();
            int index = 0;
            while (index < arraySize) {
                unorderedArray[index] = random.nextInt(40000);
                index++;
            }

            // order with the default merge algo
            long startTimeMerge = System.currentTimeMillis();
            int mergeSortResult = algo.solutionUsingPersonalMergeSort(unorderedArray);
            mergeAlgoTimeInMs += System.currentTimeMillis() - startTimeMerge;


            // order with java
            List<Integer> listToProcess = Arrays.asList(unorderedArray);
            long startTimeJava = System.currentTimeMillis();
            int javaResult = algo.solutionUsingJavaSort(listToProcess);
            javaAlgoTimeInMs += System.currentTimeMillis() - startTimeJava;

            Assert.assertEquals(mergeSortResult, javaResult);
        }

        System.out.println("\n");
        System.out.println("Merge sort time (in ms): " + mergeAlgoTimeInMs / comparisonRun);
        System.out.println("Java sort time (in ms): " + javaAlgoTimeInMs / comparisonRun);
    }


}
