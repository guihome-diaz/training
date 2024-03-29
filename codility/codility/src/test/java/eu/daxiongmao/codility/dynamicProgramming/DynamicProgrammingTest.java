package eu.daxiongmao.codility.dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTest {

    private DynamicProgramming service = new DynamicProgramming();

    @Test
    public void computeSequenceAlt() {
        Assertions.assertEquals(58, service.computeMinimumSum(new int[] {-30, 100, 10, -2}));
    }

    @Test
    public void computeSequence() {
        // exercise example
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1,5,2,-2}));

        // *************************************************************
        // personal tests cases
        // *************************************************************
        // Gobal sum is 0. Expect only '1'
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1,2,5,2,-10}));
        // Advanced cases
        Assertions.assertEquals(58, service.computeMinimumSum(new int[] {-30, 100, 10, -2}));
        Assertions.assertEquals(160, service.computeMinimumSum(new int[] {-1000, 600, 200, 30, 10}));
        Assertions.assertEquals(70, service.computeMinimumSum(new int[] {-1000, 150, 950, 30}));
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1, -1, 1, 1, 1, -5}));
        // Uniformity
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1, -1, 1, 1, 1, -1}));
        Assertions.assertEquals(1, service.computeMinimumSum(new int[] {1, -1, 1, 1, 1}));
        // corner cases
        Assertions.assertEquals(1, service.computeMinimumSum(new int[] {3, -3, 3, 4, 4}));
        Assertions.assertEquals(8, service.computeMinimumSum(new int[] {10, -10, 10, 2}));
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1, -1, 1, 1, 2}));

        // *************************************************************
        // Codility example [revealed at 2nd failure, 63% overall]
        // *************************************************************
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {3, 3, 3, 4, 5}));
        // Another custom example, like Codility
        Assertions.assertEquals(0, service.computeMinimumSum(new int[] {3, -3, 3, 4, 5}));
    }

}
