package eu.daxiongmao.codility.dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTest {

    private DynamicProgramming service = new DynamicProgramming();

    @Test
    public void computeSequence() {
        // Gobal sum is 0. Expect only '1'
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1,2,5,2,-10}));
        // Example: simple case (odd and even are a match)
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1,5,2,-2}));
        // Advance cases
        Assertions.assertEquals(58, service.computeMinimumSum(new int[] {-30, 100, 10, -2}));
        Assertions.assertEquals(160, service.computeMinimumSum(new int[] {-1000, 600, 200, 30, 10}));
        Assertions.assertEquals(70, service.computeMinimumSum(new int[] {-1000, 150, 950, 30}));
        // Codility example [revealed at 2nd failure, 63% overrall]
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {3, 3, 3, 4, 5}));
    }

}
