package eu.daxiongmao.codility.lesson1;

/**
 * Binary gap computation
 * @author Guillaume
 * @version 2021/06
 */
public class BinaryGap {

    private static final int NB_OF_BITS_IN_INTEGER = 32;
    /** An integer has 32 bits, that means the highest index of the array is int[31] because it starts from index 0. */
    private static final int MAX_INDEX_VALUE = 31;

    protected String convertNumberToBase2(final int inputNumberBase10) {
        // integers are 32 bits numbers. We just have to iterate over the bits (from 0 to 31 if required)
        if (inputNumberBase10 == 0) { return "0"; }

        char[] inputNumberBase2 = new char[NB_OF_BITS_IN_INTEGER];

        int indexValue = 1;
        int index = 0;
        while (index < MAX_INDEX_VALUE && indexValue <= inputNumberBase10) {
            // Do binary 'AND' to get the given number bit value at current index [0 or 1]
            if ((inputNumberBase10 & indexValue) > 0) {
                inputNumberBase2[MAX_INDEX_VALUE - index] = '1';
            } else {
                inputNumberBase2[MAX_INDEX_VALUE - index] = '0';
            }

            // Shift bit to compute next index value (bitwise operator << left shift)
            indexValue = indexValue << 1;
            index++;
        }

        return new String(inputNumberBase2).trim();
    }
}
