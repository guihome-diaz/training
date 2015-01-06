package eu.daxiongmao.training.codify.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOneTest {

  @Test
  public void testNoCross() {
    // Dataset
    final int testArray[] = new int[] {1, 2, 3, 4, 3, 5, 4};
    final int riverSize = 0;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(0, timeRequired);
  }

  @Test
  public void testCrossSuccessSimple() {
    // Dataset
    final int testArray[] = new int[] {1, 2, 3, 4, 3, 5, 4};
    final int riverSize = 5;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(5, timeRequired);
  }

  @Test
  public void testCrossSuccessExample() {
    // Dataset
    final int testArray[] = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
    final int riverSize = 5;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(6, timeRequired);
  }


  @Test
  public void testCrossSuccessAlternate1() {
    // Dataset
    final int testArray[] = new int[] {1, 2, 4, 2, 1, 5, 3, 4, 3};
    final int riverSize = 5;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(6, timeRequired);
  }

  @Test
  public void testCrossSuccessAlternate2() {
    // Dataset
    final int testArray[] = new int[] {1, 5, 4, 3, 2, 1, 3, 7, 6};
    final int riverSize = 7;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(8, timeRequired);
  }

  @Test
  public void testCrossFailure1() {
    // Dataset
    final int testArray[] = new int[] {2};
    final int riverSize = 2;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(-1, timeRequired);
  }

  @Test
  public void testCrossFailure2() {
    // Dataset
    final int testArray[] = new int[] {2, 3, 4, 5, 6, 7, 3, 4, 5};
    final int riverSize = 7;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(-1, timeRequired);
  }

  @Test
  public void testCrossFailure3() {
    // Dataset
    final int testArray[] = new int[] {1, 2, 4, 5, 6, 1, 1, 4, 5};
    final int riverSize = 6;

    // Algo to test
    final FrogRiverOne algo = new FrogRiverOne();
    final int timeRequired = algo.solution(riverSize, testArray);

    // Assertions
    Assert.assertEquals(-1, timeRequired);
  }
}
