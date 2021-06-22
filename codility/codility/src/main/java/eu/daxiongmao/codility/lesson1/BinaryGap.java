package eu.daxiongmao.codility.lesson1;

/**
 * Binary gap computation
 * @author Guillaume
 * @version 2021/06
 */
public class BinaryGap {

    private static final int NB_OF_BITS_IN_INTEGER = 32;

    private static final char BIT_ONE = '1';
    private static final char BIT_ZERO = '0';

    protected String convertNumberToBase2(final int inputNumberBase10) {
        if (inputNumberBase10 == 0) { return "0"; }

        // Convert to base 2
        char[] inputNumberBase2 = getBase2Representation(inputNumberBase10);

        // Remove leading '0' from the result set
        int index = 0;
        while (inputNumberBase2[index] != BIT_ONE) {
            inputNumberBase2[index] = ' ';
            index++;
        }

        return new String(inputNumberBase2).trim();
    }

    protected char[] getBase2Representation(final int inputNumberBase10) {
        // integers are 32 bits numbers. We just have to iterate over the bits (from 0 to 31 if required)
        char[] inputNumberBase2 = new char[NB_OF_BITS_IN_INTEGER];

        // Faster way to convert into base 2:
        //   Shift the original number by 1 bit on the right at every loop run, and compare with "1".
        //   That means we don't have to perform complex division, because we always compare the smallest bit.
        //   The trick is to put the results into the result array in correct order. To do so we must use a reverse ordering, from 31 to 0 (both included).
        for (int i = 31; i >= 0; i--) {
            // Shift bits in original number input to the right (operator >>)
            // Do binary 'AND' (operator '&') to compare last bit [smallest one]
            int currentValue = (inputNumberBase10 >> i) & 1;
            inputNumberBase2[NB_OF_BITS_IN_INTEGER - 1 - i] = (currentValue > 0) ? BIT_ONE : BIT_ZERO;
        }

        return inputNumberBase2;
    }

    protected int computeBinaryGap(final int inputNumberBase10) {
        if (inputNumberBase10 == 0) { return 0; }

        // Convert to base 2
        char[] inputNumberBase2 = getBase2Representation(inputNumberBase10);

        // Remove leading '0' from the result set
        int index = 0;
        while (inputNumberBase2[index] != BIT_ONE) {
            inputNumberBase2[index] = ' ';
            index++;
        }

        int maxGap = 0;
        int currentGap = 0;
        // Increase index to mark the first '1'
        index++;

        // Compute binary gap, if any
        while (index < NB_OF_BITS_IN_INTEGER) {
            if (inputNumberBase2[index] == BIT_ZERO) {
                // Increase counter on '0'
                currentGap++;
            } else {
                // cash out counter at next '1'
                if (currentGap > maxGap) {
                    maxGap = currentGap;
                }
                currentGap = 0;
            }

            // increment counter
            index++;
        }

        return maxGap;
    }
}
