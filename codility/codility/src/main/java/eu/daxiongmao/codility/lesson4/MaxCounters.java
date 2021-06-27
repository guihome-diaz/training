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
        // Option 1:
        //   Not efficient but correct: the O(n²) solution = for loop over input + another for loop to set the counters
        //   see previous commits, this is rated at 77% performance
        // Option 2:
        //   Keep a reference to MIN and MAX values. MIN value is the minimum to apply (it replaces the 2nd for loop)
        //   this is the correct solution

        int[] counters = new int[nbOfCounters];
        int currentMax = 0;
        int currentMin = 0;
        for (int i = 0; i < input.length ; i++) {
            if ((input[i] == nbOfCounters + 1)) {
                // Current max becomes the MIN value to apply everywhere
                // The minimum will be set at the end of the current loop.
                currentMin = currentMax;
            } else {
                // counter index to process (-use 1 because array's index start at 0)
                int indexItemInput = input[i] - 1;
                // Apply counter value. We must use the current MIN as reference
                if (counters[indexItemInput] < currentMin) {
                    counters[indexItemInput] = currentMin + 1;
                } else {
                    counters[indexItemInput] = counters[indexItemInput] +1;
                }
                // Set new maximum
                if (counters[indexItemInput] > currentMax) {
                    currentMax = counters[indexItemInput];
                }
            }
            // Logging # do not put that in production!
            //System.out.println("Output: " + Arrays.toString(counters));
        }

        // Apply minimum
        for (int i = 0; i < counters.length ; i++) {
            if (counters[i] < currentMin) {
                counters[i] = currentMin;
            }
        }

        System.out.println("Result: " + Arrays.toString(counters));
        System.out.println("***************************************************");
        return counters;
    }



}
