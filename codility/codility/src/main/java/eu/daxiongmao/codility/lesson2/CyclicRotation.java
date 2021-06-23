package eu.daxiongmao.codility.lesson2;

/**
 * Cyclic rotation computation
 * @author Guillaume
 * @version 2021/06
 */
public class CyclicRotation {

    private static final int MAX_ITERATIONS = 100;
    private static final int MAX_ARRAY_SIZE = 100;
    private static final int MIN_VALUE = -1000;
    private static final int MAX_VALUE = 1000;

    public int[] doCyclicRotation(final int[] input, int nbOfIterations) {
        // **********************
        // args check
        // **********************
        // Empty array : do nothing
        if (input == null || input.length == 0) { return new int[0]; }
        // No iterations required
        if (nbOfIterations == 0 || input.length == 1) { return input; }
        // Max iterations = 100
        if (nbOfIterations > MAX_ITERATIONS) { throw  new IllegalArgumentException("Too many iterations requested"); }
        // max 100 elements in the array
        if (input.length > MAX_ARRAY_SIZE) { throw new IllegalArgumentException("Too big array given"); }
        // Array content check
        boolean allValuesAreTheSame = true;
        int currentValue = input[0];
        for (int i = 0 ; i < input.length ; i++) {
            if (input[i] > MAX_VALUE) { throw new IllegalArgumentException("Array is not conform, input should not be higher than: " + MAX_VALUE); }
            if (input[i] < MIN_VALUE) { throw new IllegalArgumentException("Array is not conform, input should not be lower than: " + MIN_VALUE); }
            if (allValuesAreTheSame && input[i] != currentValue) { allValuesAreTheSame = false; }
        }
        // Same values? Rotation is useless
        if (allValuesAreTheSame) { return input; }


        // **********************
        // do rotations (iterative version)
        // **********************
        final int arrayLength = input.length;
        int rotationCounter = 0;
        int[] result = input;
        do {
            result = doRotation(result, arrayLength);
            rotationCounter++;
        } while (rotationCounter < nbOfIterations);

        return result;
    }

    private int[] doRotation(final int[] input, int arrayLength) {
        int[] sortedValues = new int[arrayLength];
        for (int index = 0 ; index < arrayLength ; index++) {
            if (index + 1 < arrayLength) {
                sortedValues[index + 1] = input[index];
            } else {
                sortedValues[0] = input[index];
            }
        }
        return sortedValues;
    }

}
