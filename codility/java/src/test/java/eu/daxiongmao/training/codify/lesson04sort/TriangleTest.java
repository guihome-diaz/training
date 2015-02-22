package eu.daxiongmao.training.codify.lesson04sort;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void exampleDataTestSuccess() {
        final Integer[] unorderedArray = new Integer[] {10, 2, 5, 1, 8, 20};

        final Triangle algo = new Triangle();
        final int result = algo.solutionWithPersonalMerge(unorderedArray);

        final int expectedResult = 1;
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void exampleDataTestFailure() {
        final Integer[] unorderedArray = new Integer[] {10, 50, 5, 1};

        final Triangle algo = new Triangle();
        final int result = algo.solutionWithPersonalMerge(unorderedArray);

        final int expectedResult = 0;
        Assert.assertEquals(expectedResult, result);
    }

}
