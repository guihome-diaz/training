package eu.daxiongmao.training.codify.lesson04sort;

import org.junit.Assert;
import org.junit.Test;

public class DistinctValuesTest {

    @Test
    public void exampleValuesTest() {
        final Integer[] unorderedArray = new Integer[] {2, 1, 1, 2, 3, 1};

        final DistinctValues algo = new DistinctValues();
        final int result = algo.solutionUsingPersonalMergeSort(unorderedArray);

        final int expectedResult = 3;
        Assert.assertEquals(expectedResult, result);
    }
}

