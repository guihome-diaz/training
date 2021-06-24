package eu.daxiongmao.codility.dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTest {

    private DynamicProgramming service = new DynamicProgramming();

    @Test
    public void computeSequence() {
        // Example: simple case (odd and even are a match)
        //Assertions.assertEquals(0, service.computeMinimumSum(new int[] {1, 5, 2, -2}));

        Assertions.assertEquals(-58, service.computeMinimumSum(new int[] {-30, 100, 10, -2}));

    }

}
