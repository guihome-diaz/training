package eu.daxiongmao.codility.lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * To find the odd occurrence in an array (mistigri)
 * @author Guillaume
 * @version 2021/06
 */
public class OddOccurrencesInArray {

    private static final int MAX_ARRAY_SIZE = 1000000;
    private static final int MAX_ARRAY_ITEM_VALUE = 1000000000;

    public int findOddOccurrence(final int[] input) {
        if (input.length == 0) { throw new IllegalArgumentException("Input is required"); }
        if (input.length % 2 == 0) { throw new IllegalArgumentException("This algorithm require an array with ODD size to work"); }
        if (input.length > MAX_ARRAY_SIZE) { throw new IllegalArgumentException("Given input is too big"); }

        /**
         * Key: number
         * Value: nb of occurrences. If not pair => it is the mistigri!
         */
        final HashMap<Integer, Integer> nbOfOccurrences = new HashMap<>();

        // Go through the list and populate the list of occurrences
        // Complexity: O(n) for the loop + log(n) to populate the map
        for (int i = 0; i < input.length ; i++) {
            int currentValue = input[i];
            // Check value
            if (currentValue < 0 || currentValue > MAX_ARRAY_ITEM_VALUE) {
                throw new IllegalArgumentException("Array contains an invalid element at position: " + i + ". Numbers must be between [0 .. " + MAX_ARRAY_ITEM_VALUE + "]");
            }
            // do computation
            if (nbOfOccurrences.containsKey(currentValue)) {
                nbOfOccurrences.put(currentValue, nbOfOccurrences.get(currentValue) + 1);
            } else {
                nbOfOccurrences.put(input[i], 1);
            }
        }

        // find the mistigri
        // log(n) to go through the list
        int result = 0;
        for (Map.Entry<Integer, Integer> occurrence : nbOfOccurrences.entrySet()) {
            if (occurrence.getValue() % 2 != 0) {
                result = occurrence.getKey();
                break;
            }
        }

        return result;
    }

}
