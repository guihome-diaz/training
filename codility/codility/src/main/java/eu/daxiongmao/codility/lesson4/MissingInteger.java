package eu.daxiongmao.codility.lesson4;

import java.util.*;

/**
 * To find the smallest positive integer (greater than 0) that does not occur in A.
 * @author Guillaume
 * @version 2.0 # 2021/06
 * @version 1.0 # 2015/01
 */
public class MissingInteger {

    private static final int MIN_POSITIVE_INTEGER = 1;

    /**
     * To find the smallest positive integer (greater than 0) that does not occur in A.
     * That means the method will return 1 if there are no positive integers or zeros only
     * @param input array to check
     * @return smallest positive integer (greater than 0) that does not occur in A
     */
    public int getPositiveMissingInteger(final int[] input) {
        System.out.println("***********************************");
        System.out.println("Given: " + Arrays.toString(input));
        if (input.length == 0) {
            System.out.println("Nothing to process. Missing value: " + MIN_POSITIVE_INTEGER);
            return MIN_POSITIVE_INTEGER;
        }

        // ****** Extract positive integers (keep distinct values only) + get min
        // Because input array length is limited to 1 000 000 (even though each value varies from (-) Integer.MAX)
        //    the missing integer must be within [0...array.length]
        //    In worst case, if the array is a suite, then the missing integer will be (array.length + 1)
        final int[] positiveValues = new int[input.length];
        int minPositiveInteger = Integer.MAX_VALUE;
        boolean hasPositiveValues = false;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0 && input[i] <= input.length) {
                // register value (careful, java magic: array starts at 0)
                positiveValues[input[i] - 1] = 1;
                hasPositiveValues = true;
                if (input[i] < minPositiveInteger) {
                    minPositiveInteger = input[i];
                }
            }
        }
        // ****** basic processing
        if (!hasPositiveValues) {
            // No positive integers (only negatives or zeros): return 1
            System.out.println("Only negatives or zeros. Missing value: " + MIN_POSITIVE_INTEGER);
            return MIN_POSITIVE_INTEGER;
        }
        if (minPositiveInteger > MIN_POSITIVE_INTEGER) {
            // Minimum is higher than smallest expectation: return 1
            System.out.println("Minimum value is not included. Missing value: " + MIN_POSITIVE_INTEGER);
            return MIN_POSITIVE_INTEGER;
        }

        // ******  find the missing value
        int index = 0;
        while (index < positiveValues.length && positiveValues[index] == 1) {
            // index[i] should be equal to 1. Else value i+1 is missing
            index++;
        }
        if (index < positiveValues.length) {
            System.out.println("Missing value: " + index + 1);
            return index + 1;
        } else {
            System.out.println("Missing value: " + positiveValues.length + 1);
            return positiveValues.length + 1;
        }
    }

}
