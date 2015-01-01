package eu.daxiongmao.training.codify.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class PermutationTest {

  @Test
  public void testWrongCompleteArray() {
    // test dataset
    final int[] testArray = new int[7];
    testArray[0] = 1;
    testArray[1] = 2;
    testArray[2] = 0;
    testArray[3] = 4;
    testArray[4] = 3;
    testArray[5] = 6;
    testArray[6] = 5;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, missingElement);
  }

  @Test
  public void testCompleteArray() {
    // test dataset
    final int[] testArray = new int[7];
    testArray[0] = 1;
    testArray[1] = 2;
    testArray[2] = 7;
    testArray[3] = 4;
    testArray[4] = 3;
    testArray[5] = 6;
    testArray[6] = 5;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingElement);
  }

  @Test
  public void testWrongShortArray() {
    // test dataset
    final int[] testArray = new int[2];
    testArray[0] = 2;
    testArray[1] = 3;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, missingElement);
  }

  @Test
  public void testVeryShortArray() {
    // test dataset
    final int[] testArray = new int[1];
    testArray[0] = 1;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingElement);
  }

  @Test
  public void testWrongVeryShortArray() {
    // test dataset
    final int[] testArray = new int[1];
    testArray[0] = 8;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, missingElement);
  }

  @Test
  public void testShortArray() {
    // test dataset
    final int[] testArray = new int[2];
    testArray[0] = 2;
    testArray[1] = 1;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingElement);
  }

  @Test
  public void testMissingEndElement() {
    // test dataset
    final int[] testArray = new int[6];
    testArray[0] = 1;
    testArray[1] = 2;
    testArray[2] = 5;
    testArray[3] = 4;
    testArray[4] = 3;
    testArray[5] = 7;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, missingElement);
  }

  @Test
  public void testMissingElement() {
    // test dataset
    final int[] testArray = new int[7];
    testArray[0] = 7;
    testArray[1] = 4;
    testArray[2] = 6;
    testArray[3] = 5;
    testArray[4] = 8;
    testArray[5] = 2;
    testArray[6] = 1;

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(0, missingElement);
  }

  @Test
  public void testEmptyArray() {
    // test dataset
    final int[] testArray = new int[0];

    // Algo to test
    final Permutation algo = new Permutation();
    final int missingElement = algo.solution(testArray);

    // Assertions

    // Careful! As per the specifications the first value expected is 1, not 0!!
    Assert.assertEquals(0, missingElement);
  }
}
