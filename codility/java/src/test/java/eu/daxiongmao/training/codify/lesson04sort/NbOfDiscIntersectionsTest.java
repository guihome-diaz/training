package eu.daxiongmao.training.codify.lesson04sort;


import org.junit.Assert;
import org.junit.Test;

public class NbOfDiscIntersectionsTest {

    @Test
    public void exampleDataSet() {
        Integer[] unsortedArray = new Integer[] {1, 5, 2, 1, 4, 0};

        final NbOfDiscIntersections algo = new NbOfDiscIntersections();
        final int result = algo.badSolution(unsortedArray);

        final int expectedResult = 11;
        Assert.assertEquals(expectedResult, result);
    }

}
