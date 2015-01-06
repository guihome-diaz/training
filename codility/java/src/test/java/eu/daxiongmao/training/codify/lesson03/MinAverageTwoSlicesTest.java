package eu.daxiongmao.training.codify.lesson03;

import org.junit.Assert;
import org.junit.Test;

public class MinAverageTwoSlicesTest {

  @Test
  public void testGivenExample() {
    // Dataset
    final int testArray[] = new int[] {4, 2, 2, 5, 1, 5, 8};

    // Algo to test
    final MinAverageTwoSlices algo = new MinAverageTwoSlices();
    final int minAverageStartPoint = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, minAverageStartPoint);
  }

  @Test
  public void testArrayNegativeValues() {
    // Dataset
    final int testArray[] = new int[] {1000, -250000, 150000, 200};

    // Algo to test
    final MinAverageTwoSlices algo = new MinAverageTwoSlices();
    final int minAverageStartPoint = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, minAverageStartPoint);
  }

  @Test
  public void testArrayEmpty() {
    // Dataset
    final int testArray[] = new int[0];

    // Algo to test
    final MinAverageTwoSlices algo = new MinAverageTwoSlices();
    final int minAverageStartPoint = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, minAverageStartPoint);
  }

  @Test
  public void testArraySingleValue() {
    // Dataset
    final int testArray[] = new int[] {1};

    // Algo to test
    final MinAverageTwoSlices algo = new MinAverageTwoSlices();
    final int minAverageStartPoint = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, minAverageStartPoint);
  }


}
