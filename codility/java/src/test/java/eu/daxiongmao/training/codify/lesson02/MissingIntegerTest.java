package eu.daxiongmao.training.codify.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class MissingIntegerTest {

  @Test
  public void testGivenExample() {
    // Dataset
    final int testArray[] = new int[] {1, 3, 6, 4, 1, 2};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(5, missingInteger);
  }


  @Test
  public void testAlternateExample() {
    // Dataset
    final int testArray[] = new int[] {1, 3, 6, 4, 1, 7, 8};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(2, missingInteger);
  }

  @Test
  public void testNegativeExample() {
    // Dataset
    final int testArray[] = new int[] {-1, 0, -3, -6, -4, -1, -7, -8};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingInteger);
  }

  @Test
  public void testEmptyArray() {
    // Dataset
    final int testArray[] = new int[0];

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingInteger);
  }

  @Test
  public void testLargeValues() {
    // Dataset
    final int testArray[] = new int[] {Integer.MAX_VALUE, 2};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingInteger);
  }

  @Test
  public void testAlmostEmptyArray() {
    // Dataset
    final int testArray[] = new int[] {2};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(1, missingInteger);
  }

  @Test
  public void testAlternateExample2() {
    // Dataset
    final int testArray[] = new int[] {2, 3, 6, 4, 1, 7, 8, 5};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(9, missingInteger);
  }

  @Test
  public void testAlternateExample3() {
    // Dataset
    final int testArray[] = new int[] {0, 2, -3, 1, 6, -4, 4, -1, 7, 8, 5};

    // Algo to test
    final MissingInteger algo = new MissingInteger();
    final int missingInteger = algo.solution(testArray);

    // Assertions
    Assert.assertEquals(3, missingInteger);
  }

}
