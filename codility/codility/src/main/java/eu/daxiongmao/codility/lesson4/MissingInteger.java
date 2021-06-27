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

        // Extract positive integers (keep distinct values only) + get min / max
        //   (i) use sorted set for automatic sorting by the JVM
        int minPositiveInteger = Integer.MAX_VALUE;
        int maxPositiveInteger = 0;
        final SortedSet<Integer> positiveIntegers = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                positiveIntegers.add(input[i]);
                if (input[i] < minPositiveInteger) {
                    minPositiveInteger = input[i];
                }
                if (input[i] > maxPositiveInteger) {
                    maxPositiveInteger = input[i];
                }
            }
        }
        if (positiveIntegers.isEmpty()) {
            // No positive integers (only negatives or zeros): return 1
            System.out.println("Missing value: " + MIN_POSITIVE_INTEGER);
            return MIN_POSITIVE_INTEGER;
        }
        if (minPositiveInteger > MIN_POSITIVE_INTEGER) {
            // Minimum is higher than smallest expectation: return 1
            System.out.println("Missing value: " + MIN_POSITIVE_INTEGER);
            return MIN_POSITIVE_INTEGER;
        }

        // find the missing value
        //   (i) Java iterate from smallest to highest index by default
        int currentMin = MIN_POSITIVE_INTEGER;
        int missingInteger = 0;
        for (int setValue : positiveIntegers) {
            if (setValue == currentMin + 1) {
                // as expected
                currentMin = setValue;
            } else if (setValue == currentMin) {
                // Min value do nothing. this should only occur at start
                continue;
            } else {
                // error: with should have minimum over here!
                missingInteger = currentMin + 1;
                break;
            }
        }
        // Array is a correct suite. Missing value is the next one
        if (missingInteger == 0) {
            missingInteger = maxPositiveInteger + 1;
        }

        System.out.println("Missing value: " + missingInteger);
        return missingInteger;
    }

}
