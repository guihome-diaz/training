package eu.daxiongmao.training.codify.lesson03sum;

import org.junit.Assert;
import org.junit.Test;

public class PassingCarsTest {

  @Test
  public void testGivenExample() {
    // Dataset
    final int testArray[] = new int[] {0, 1, 0, 1, 1};

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(5, nbOfCarCrossing);
  }

  @Test
  public void testAlternateExample() {
    // Dataset
    final int testArray[] = new int[] {0, 1, 0, 1, 1, 0, 1, 1, 1};

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(14, nbOfCarCrossing);
  }

  @Test
  public void testSingleCross() {
    // Dataset
    final int testArray[] = new int[] {1, 1, 1, 0, 1, 1, 1, 1, 1};

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(5, nbOfCarCrossing);
  }

  @Test
  public void testNoCrossingEast() {
    // Dataset
    final int testArray[] = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, nbOfCarCrossing);
  }

  @Test
  public void testNoCrossingWest() {
    // Dataset
    final int testArray[] = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, nbOfCarCrossing);
  }


  @Test
  public void testNoCars() {
    // Dataset
    final int testArray[] = new int[0];

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, nbOfCarCrossing);
  }

  /**
   * This test aims to trigger the max. value and get the error code -1.
   */
  @Test
  public void testCrazyHuge() {
    final int testArray[] = new int[1000000];
    for (int i = 1; i < testArray.length; i++) {
      if (i % 2 > 0) {
        testArray[i] = 1;
      }
    }

    // Algo to test
    final PassingCars algo = new PassingCars();
    final int nbOfCarCrossing = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(-1, nbOfCarCrossing);
  }

}
