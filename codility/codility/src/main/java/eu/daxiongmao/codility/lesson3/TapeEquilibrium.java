package eu.daxiongmao.codility.lesson3;

import java.util.HashMap;
import java.util.Map;

/**
 * Tape equilibirum exercise
 * @author Guillaume
 * @version 2021/06
 */
public class TapeEquilibrium {

    private static final int MAX_ARRAY_SIZE = 100000;
    private static final int MIN_ARRAY_SIZE = 2;

    public int computeTapeEquilibrium(final int[] input) {
        if (input.length < MIN_ARRAY_SIZE || input.length > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException("You must give an array filled with values. Empty arrays are not accepted, length must be at least " + MIN_ARRAY_SIZE);
        }

        // After checks, it appears that the average isn't always the best possibility, especially when you're dealing with negative numbers.
        // It is better to compute all possibilities for faceA and faceB, then compare.

        // 1. Compute all for faceA (starting from index 0)
        //    Stop 1 before the end because faceB cannot be empty
        final Map<Integer, Integer> faceAsumByIndex = new HashMap<>();
        int currentSum = 0;
        for (int index = 0; index < input.length - 1; index++) {
            currentSum += input[index];
            faceAsumByIndex.put(index, currentSum);
        }

        // 2. Do the same for faceB (starting from index N) and compare the results
        //    Stop 1 before the end because faceA cannot be empty
        currentSum = 0;
        int minResult = Integer.MAX_VALUE;
        for (int index = input.length - 1; index > 0; index--) {
            // Compute faceB sum
            currentSum += input[index];
            // Compare with faceA (index - 1)
            int currentDifference = Math.abs(faceAsumByIndex.get(index - 1) - currentSum);
            if (currentDifference < minResult) {
                minResult = currentDifference;
            }
        }

        return minResult;
    }

}
