package eu.daxiongmao.training.codify.lesson01;

import org.junit.Assert;
import org.junit.Test;

public class SplitTest {

  @Test
  public void testFewElements() {
    // Dataset
    final int[] arrayToTest = new int[] {3};

    // Function to test
    final Split algo = new Split();
    final int result2 = algo.goodSolution(arrayToTest);

    // Assertions
    Assert.assertEquals(0, result2);
  }

  @Test
  public void testNominalCase() {
    // Dataset
    final int[] arrayToTest = new int[] {3, 1, 2, 4, 3};

    // Function to test
    final Split algo = new Split();
    final int result2 = algo.goodSolution(arrayToTest);

    // Assertions
    Assert.assertEquals(1, result2);
  }

  @Test
  public void testEmpty() {
    // Dataset
    final int[] arrayToTest = new int[] {};

    // Function to test
    final Split algo = new Split();
    final int result2 = algo.goodSolution(arrayToTest);

    // Assertions
    Assert.assertEquals(0, result2);
  }

  @Test
  public void testNull() {
    // Function to test
    final Split algo = new Split();
    final int result2 = algo.goodSolution(null);

    // Assertions
    Assert.assertEquals(0, result2);
  }
}
