package eu.daxiongmao.codility.lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryGapTest {

    private BinaryGap binaryGap = new BinaryGap();

    @Test
    @DisplayName("Convert number to base 2")
    public void convertToBase2() {
        // For all integers: compare with default java algo
        for (int i = 0 ; i < Integer.MAX_VALUE; i++) {
            Assertions.assertEquals(Integer.toBinaryString(i), binaryGap.convertNumberToBase2(i));
        }

        // Given values in examples
        Assertions.assertEquals("1001", binaryGap.convertNumberToBase2(9));
        Assertions.assertEquals("1000010001", binaryGap.convertNumberToBase2(529));
        Assertions.assertEquals("10100", binaryGap.convertNumberToBase2(20));
        Assertions.assertEquals("111", binaryGap.convertNumberToBase2(15));
        Assertions.assertEquals("100000", binaryGap.convertNumberToBase2(32));
        Assertions.assertEquals("10000010001", binaryGap.convertNumberToBase2(1041));

    }

}
