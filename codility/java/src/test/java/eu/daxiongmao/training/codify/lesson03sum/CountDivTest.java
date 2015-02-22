package eu.daxiongmao.training.codify.lesson03sum;

import org.junit.Assert;
import org.junit.Test;

public class CountDivTest {

  @Test
  public void testGivenExample() {
    // Dataset
    final int startTestRange = 6;
    final int endTestRange = 11;
    final int moduloTest = 2;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(3, nbOfDivisions);
  }

  @Test
  public void testAlternateSimpleExample() {
    // Dataset
    final int startTestRange = 0;
    final int endTestRange = 33;
    final int moduloTest = 3;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(12, nbOfDivisions);
  }

  @Test
  public void testAlternateExampleUsingPrime() {
    // Dataset
    final int startTestRange = 100;
    final int endTestRange = 300;
    final int moduloTest = 113;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(2, nbOfDivisions);
  }

  @Test
  public void testAlternateExampleUsingAdvancedPrime() {
    // Dataset
    final int startTestRange = 80;
    final int endTestRange = 89;
    final int moduloTest = 29;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(1, nbOfDivisions);
  }

  @Test
  public void testAlternateExampleWith0() {
    // Dataset
    final int startTestRange = 0;
    final int endTestRange = 1;
    final int moduloTest = 11;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(1, nbOfDivisions);
  }

  @Test
  public void testAlternateExampleUsingBase10() {
    // Dataset
    final int startTestRange = 80;
    final int endTestRange = 91;
    final int moduloTest = 10;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(2, nbOfDivisions);
  }

  @Test
  public void testNoCounterBadCondition() {
    // Dataset
    final int startTestRange = 1;
    final int endTestRange = 7;
    final int moduloTest = 9;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(0, nbOfDivisions);
  }

  @Test
  public void testNoCounter() {
    // Dataset
    final int startTestRange = 6;
    final int endTestRange = 7;
    final int moduloTest = 4;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(0, nbOfDivisions);
  }

  @Test
  public void testSingleCounter() {
    // Dataset
    final int startTestRange = 6;
    final int endTestRange = 6;
    final int moduloTest = 2;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(1, nbOfDivisions);
  }


  @Test
  public void testSingleCounterAdvanced() {
    // Dataset
    final int startTestRange = 80;
    final int endTestRange = 81;
    final int moduloTest = 80;

    // Algo to test
    final CountDiv algo = new CountDiv();
    final int nbOfDivisions = algo.solution(startTestRange, endTestRange, moduloTest);

    // Assertions
    Assert.assertEquals(1, nbOfDivisions);
  }
}
