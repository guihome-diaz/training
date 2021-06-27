package eu.daxiongmao.codility.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingIntegerTest {

    private MissingInteger service = new MissingInteger();

    @Test
    public void findMissingPositiveInteger() {
        // No positive value
        Assertions.assertEquals(1, service.getPositiveMissingInteger(new int[] {-1, -3}));
        Assertions.assertEquals(1, service.getPositiveMissingInteger(new int[] {-1, -2, -3, 0, 0}));
        // Missing minimum (1)
        Assertions.assertEquals(1, service.getPositiveMissingInteger(new int[] {2,3,4,5,6}));
        // Missing next
        Assertions.assertEquals(4, service.getPositiveMissingInteger(new int[] {2,1,3}));
        // Processing
        Assertions.assertEquals(5, service.getPositiveMissingInteger(new int[] {1, 3, 6, 4, 1, 2}));
        Assertions.assertEquals(5, service.getPositiveMissingInteger(new int[] {7,8,9,6,4,3,1,2}));
    }

}
