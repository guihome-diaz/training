package eu.daxiongmao.training.codify.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To process tape equilibrium algorithm. <br>
 * see https://codility.com/demo/take-sample-test/tape_equilibrium
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class TapeEquilibrium {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(TapeEquilibrium.class);

  /**
   * This is a GOOD solution since it produces a result in O(n)
   *
   * @param array array to process
   * @return min(|leftPart - rightPart|)
   */
  public int solution(final int[] array) {
    if (array == null || array.length <= 1) {
      // Avoid NPE... Return 0 instead
      return 0;
    }

    /*
     * Key: split index Value: left sum
     */
    final Map<Integer, Long> leftSums = new HashMap<>();

    // Compute indexes
    long currentLeftSum = 0;
    for (int i = 0; i < array.length; i++) {
      currentLeftSum += array[i];
      if (i < array.length - 1) {
        leftSums.put(i + 1, currentLeftSum);
      }
    }
    final long total = currentLeftSum;

    // Compute totals
    Long result = null;
    for (final Map.Entry<Integer, Long> entry : leftSums.entrySet()) {
      final long sumRight = total - entry.getValue();
      final long temp = Math.abs(entry.getValue() - sumRight);
      LOGGER.debug(String.format("Good solution:  P = %s ==> |%s- %s| ==> %s", entry.getKey(),
          entry.getValue(), sumRight, temp));
      if (result == null || temp < result) {
        result = temp;
      }
    }

    return result.intValue();
  }

  /**
   * @deprecated use {@link #solution(int[])} instead
   */
  @Deprecated
  int badSolution(final int[] array) {
    if (array == null || array.length <= 1) {
      // Avoid NPE... Return 0 instead
      return 0;
    }

    Integer result = null;
    // Go over the array, from the 1st to the last value
    for (int splitIndex = 1; splitIndex < array.length; splitIndex++) {
      final int temp = badSolutionComputeSplit(array, splitIndex);
      if (result == null || temp < result) {
        result = temp;
      }
    }

    return result;
  }

  private int badSolutionComputeSplit(final int[] arrayToProcess, final int split) {
    int sumLeft = 0;
    int sumRight = 0;
    for (int i = 0; i < arrayToProcess.length; i++) {
      if (i <= split - 1) {
        sumLeft += arrayToProcess[i];
      } else {
        sumRight += arrayToProcess[i];
      }
    }
    final int result = Math.abs(sumLeft - sumRight);
    LOGGER.debug(String.format("bad solution:  P = %s ==> |%s- %s| ==> %s", split, sumLeft,
        sumRight, result));
    return result;
  }

}
