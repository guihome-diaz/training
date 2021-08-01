package eu.daxiongmao.codility.lesson3;

/**
 * Find missing permutation exercise
 * @author Guillaume
 * @version 2021/06
 */
public class PermMissingElem {

    public static final int MAX_ARRAY_SIZE = 100000;

    public int getMissingElement(final int[] input) {
        if (input.length > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException("You must give a populated array with a length between [0.." + MAX_ARRAY_SIZE + "]");
        }

        // After first trial, it appears that you CAN provide an empty array.
        // In such case we have to return the 1st value after 0
        if (input.length == 0) { return 1; }

        // Temporary array, to store the numbers.
        // temp[i] == 1, then the 'i' number exists in original input.
        // temp[i] == 0, then the 'i' number does NOT exists in original input
        // (!) Array size is +2 because 'i' start at 1 and can be max value original input + 1
        //     temp[0] is not relevant
        int[] tempArray = new int[input.length + 2];

        // populate temporary array (ordered list)
        for (int i = 0; i < input.length; i++) {
            tempArray[input[i]] = 1;
        }
        // Find the problem
        int missingValue = 0;
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] == 0) {
                missingValue = i;
                break;
            }
        }
        return missingValue;
    }

}
