package eu.daxiongmao.codility.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxCountersTest {

    private MaxCounters service = new MaxCounters();

    @Test
    public void maxCounters() {
        // example value
        Assertions.assertTrue(compareArrays(new int[] {3, 2, 2, 4, 2}, service.computeCounters(5, new int[] {3,4,4,6,1,4,4})));
        Assertions.assertTrue(compareArrays(new int[] {1, 1, 1, 1, 1}, service.computeCounters(5, new int[] {1,2,3,4,5})));
        // Single size
        Assertions.assertTrue(compareArrays(new int[] {5}, service.computeCounters(1, new int[] {1,2,1,2,1,2,1,2,1,2})));
        // No increase
        Assertions.assertTrue(compareArrays(new int[] {0, 0, 0, 0, 0}, service.computeCounters(5, new int[] {6,6,6,6,6,6,6})));
    }

    private boolean compareArrays(int[] expectations, int[] result) {
        Assertions.assertEquals(expectations.length, result.length, "Expectations and results aren't the same");
        for (int i = 0; i < expectations.length; i++) {
            Assertions.assertEquals(expectations[i], result[i], String.format("Expectation[%d]=%d | Got result[%d]=%d", i, expectations[i], i, result[i]));
        }
        return true;
    }

}
