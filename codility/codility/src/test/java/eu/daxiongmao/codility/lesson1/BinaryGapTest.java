package eu.daxiongmao.codility.lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryGapTest {

    private BinaryGap binaryGap = new BinaryGap();

    @Test
    @DisplayName("Convert number to base 2")
    public void convertToBase2() {

        // Brute force for all integers: compare with default java algo
        /*
        for (int i = 0 ; i < Integer.MAX_VALUE; i++) {
            Assertions.assertEquals(Integer.toBinaryString(i), binaryGap.convertNumberToBase2(i));
        }
        */

        // Given values in examples
        Assertions.assertEquals("1001", binaryGap.convertNumberToBase2(9));
        Assertions.assertEquals("1000010001", binaryGap.convertNumberToBase2(529));
        Assertions.assertEquals("10100", binaryGap.convertNumberToBase2(20));
        Assertions.assertEquals("1111", binaryGap.convertNumberToBase2(15));
        Assertions.assertEquals("100000", binaryGap.convertNumberToBase2(32));
        Assertions.assertEquals("10000010001", binaryGap.convertNumberToBase2(1041));

        // Limits
        Assertions.assertEquals(Integer.toBinaryString(0), binaryGap.convertNumberToBase2(0));
        Assertions.assertEquals(Integer.toBinaryString(Integer.MAX_VALUE), binaryGap.convertNumberToBase2(Integer.MAX_VALUE));

        // Random values
        Assertions.assertEquals(Integer.toBinaryString(8595879), binaryGap.convertNumberToBase2(8595879));
    }

    @Test
    @DisplayName("Compute binary gap")
    public void computeBinaryGap() {

        // Brute force for all integers: compare with default java algo
        /*
        for (int i = 0 ; i < Integer.MAX_VALUE; i++) {
            Assertions.assertEquals(Integer.toBinaryString(i), binaryGap.convertNumberToBase2(i));
        }
        */

        // Given values in examples
        Assertions.assertEquals(2, binaryGap.computeBinaryGap(9));
        Assertions.assertEquals(4, binaryGap.computeBinaryGap(529));
        Assertions.assertEquals(1, binaryGap.computeBinaryGap(20));
        Assertions.assertEquals(0, binaryGap.computeBinaryGap(15));
        Assertions.assertEquals(0, binaryGap.computeBinaryGap(32));
        Assertions.assertEquals(5, binaryGap.computeBinaryGap(1041));

        // Limits
        Assertions.assertEquals(0, binaryGap.computeBinaryGap(0));
        Assertions.assertEquals(0, binaryGap.computeBinaryGap(Integer.MAX_VALUE));
    }
}
