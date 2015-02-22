package eu.daxiongmao.training.codify.lesson03sum;

import org.junit.Assert;
import org.junit.Test;

public class GenomeRangeQueryTest {

  @Test
  public void testAlmostAllTheSameGenom() {
    // Dataset
    final String dnaSequence = "CCCCCCCCCCCCCCCCACCCCCCCC";
    final int queriesP[] = new int[] {0, 10, 3};
    final int queriesQ[] = new int[] {20, 12, 15};

    // Algo to test
    final GenomeRangeQuery algo = new GenomeRangeQuery();
    final int[] results = algo.solution(dnaSequence, queriesP, queriesQ);

    // Assertions
    Assert.assertEquals(queriesP.length, results.length);
    Assert.assertEquals(1, results[0]);
    Assert.assertEquals(2, results[2]);
    Assert.assertEquals(2, results[1]);
  }

  @Test
  public void testSingleGenom() {
    // Dataset
    final String dnaSequence = "C";
    final int queriesP[] = new int[] {0};
    final int queriesQ[] = new int[] {0};

    // Algo to test
    final GenomeRangeQuery algo = new GenomeRangeQuery();
    final int[] results = algo.solution(dnaSequence, queriesP, queriesQ);

    // Assertions
    Assert.assertEquals(queriesP.length, results.length);
    Assert.assertEquals(2, results[0]);
  }

  @Test
  public void testGivenExample() {
    // Dataset
    final String dnaSequence = "CAGCCTA";
    final int queriesP[] = new int[] {2, 5, 0};
    final int queriesQ[] = new int[] {4, 5, 6};

    // Algo to test
    final GenomeRangeQuery algo = new GenomeRangeQuery();
    final int[] results = algo.solution(dnaSequence, queriesP, queriesQ);

    // Assertions
    Assert.assertEquals(queriesP.length, results.length);
    Assert.assertEquals(2, results[0]);
    Assert.assertEquals(4, results[1]);
    Assert.assertEquals(1, results[2]);
  }
}
