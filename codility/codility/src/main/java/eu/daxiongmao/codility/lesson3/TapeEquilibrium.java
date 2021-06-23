package eu.daxiongmao.codility.lesson3;

/**
 * Tape equilibirum exercise
 * @author Guillaume
 * @version 2021/06
 */
public class TapeEquilibrium {

    private static final int MAX_ARRAY_SIZE = 100000;
    private static final int MIN_ARRAY_SIZE = 2;
    private static final int MIN_ITEM_VALUE = -1000;
    private static final int MAX_ITEM_VALUE = 1000;

    public int computeTapeEquilibrium(final int[] input) {
        if (input.length < MIN_ARRAY_SIZE || input.length > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException("You must give an array filled with values. Empty arrays are not accepted, length must be at least " + MIN_ARRAY_SIZE);
        }

        // First do the sum of all values
        int arraySum = 0;
        for (int item : input) {
            if (item < MIN_ITEM_VALUE || item > MAX_ITEM_VALUE) {
                throw new IllegalArgumentException("Array contains an incorrect value (" + item + "). Input is not valid");
            }
            arraySum += item;
        }
        final float splitValue = (float) arraySum / 2;

        // Compute total face A and find the middle
        int middleIndex = 0;
        int totalFaceA = 0;
        for (int item : input) {
            // Do not pass the middle
            if (totalFaceA + item > splitValue) { break; }
            // Register value until middle is reached
            totalFaceA += item;
            middleIndex++;
        }
        int alternateTotalFaceA = totalFaceA + input[middleIndex];

        // Compute total face B
        int totalFaceB = 0;
        for (int i = middleIndex; i < input.length; i++) {
            totalFaceB += input[i];
        }
        int alternateTotalFaceB = totalFaceB - input[middleIndex];

        // Compare the 2 options
        int middleOnFaceB = Math.abs(totalFaceA - totalFaceB);
        int middleOnFaceA = Math.abs(alternateTotalFaceA - alternateTotalFaceB);

        // Return best result
        return Math.min(middleOnFaceA, middleOnFaceB);
    }

}
