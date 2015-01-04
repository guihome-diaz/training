package eu.daxiongmao.training.codify.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class CounterIncrementTest {

  @Test
  public void testGivenExample() {
    // Dataset
    final int testArray[] = new int[] {3, 4, 4, 6, 1, 4, 4};
    final int counter = 5;

    // Algo to test
    final CounterIncrement algo = new CounterIncrement();
    final int[] outputResult = algo.counterIncrement(counter, testArray);

    // Assertions
    Assert.assertEquals(counter, outputResult.length);

    final int[] expectedResults = new int[] {3, 2, 2, 4, 2};
    for (int i = 0; i < counter; i++) {
      Assert.assertEquals(String.format("Expected: [%s]=%s", i, expectedResults[i]),
          expectedResults[i], outputResult[i]);
    }

  }

}
