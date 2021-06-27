package eu.daxiongmao.codility.lesson4;

import java.util.Arrays;

/**
 * Max counters algorithm
 * @author Guillaume
 * @version 2.0 # 2021/06
 * @version 1.0 # 2015/01
 */
public class MaxCounters {

    /**
     * To compute counters corresponding to input[] array based on the Max counter algorithm definition (see https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/)
     * @param nbOfCounters number of counters to handle. This is the <strong>N</strong> variable of the description. it's value is the range [1..100,000]
     * @param input array of M integers (M range [1..100,000]), each array item value is between [1, ... nbOfCounters + 1]. This is the variable <strong>A</strong> from the description
     * @return counters values
     */
    public int[] computeCounters(final int nbOfCounters, final int[] input) {
        System.out.println("Given # N=" + nbOfCounters + " | A" + Arrays.toString(input));

        // arg check
        if (nbOfCounters < 1) {
            throw new IllegalArgumentException("You must give a nb of counters in the range [1 .. 100 000]");
        }
        if (input.length == 0) {
            throw new IllegalArgumentException("You must give a non empty input array A with M integers (total integers must be in range [1 .. 100 000])");
        }

        // Processing
        int[] counters = new int[nbOfCounters];
        int currentMax = 0;
        for (int i = 0 ; i < input.length ; i++) {
            if ((input[i] == nbOfCounters + 1)) {
                // do nothing if counter length is 1
                if (counters.length > 1) {
                    // Max value: set all counters to current max
                    for (int k = 0; k < counters.length; k++) {
                        counters[k] = currentMax;
                    }
                }
            } else {
                int indexItemInput = input[i] - 1;
                // Set counter value. Careful: index start at '0'
                counters[indexItemInput] = counters[indexItemInput] + 1;
                if (counters[indexItemInput] > currentMax) {
                    currentMax = counters[indexItemInput];
                }
            }

            // Logging # do not put that in production!
            //System.out.println("Output: " + Arrays.toString(counters));
        }

        System.out.println("Result: " + Arrays.toString(counters));
        System.out.println("***************************************************");
        return counters;
    }



}
