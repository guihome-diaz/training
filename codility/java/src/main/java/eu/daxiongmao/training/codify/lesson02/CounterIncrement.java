package eu.daxiongmao.training.codify.lesson02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterIncrement {


  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(CounterIncrement.class);

  /**
   * <p>
   * To compute the following algorithm:<br/>
   * You are given N counters, initially set to 0, and you have two possible operations on them:
   * <ul>
   * <li>increase(X) − counter X is increased by 1</li>
   * <li>max counter − all counters are set to the maximum value of any counter</li>
   * </ul>
   * A non-empty zero-indexed array A of M integers is given. <br/>
   * This array represents consecutive operations:
   * <ul>
   * <li>if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X)</li>
   * <li>if A[K] = N + 1 then operation K is max counter</li>
   * </ul>
   * </p>
   * <p>
   * For example, given integer N = 5 and array A such that:<br/>
   * A[] = {3, 4, 4, 6, 1, 4, 4}<br/>
   * the values of the counters after each consecutive operation will be:<br/>
   * <ol>
   * <li>round 1: (0, 0, 1, 0, 0)</li>
   * <li>round 2: (0, 0, 1, 1, 0)</li>
   * <li>round 3: (0, 0, 1, 2, 0)</li>
   * <li>round 4: (2, 2, 2, 2, 2)</li>
   * <li>round 5: (3, 2, 2, 2, 2)</li>
   * <li>round 6: (3, 2, 2, 3, 2)</li>
   * <li>round 7: (3, 2, 2, 4, 2)</li>
   * </ol>
   *
   * @param counterNumber number of counter to create in the output array. This also set the limit
   *        between increase | max counter operations
   * @param array array to analyze
   * @return new array with output results
   */
  public int[] counterIncrement(final int counterNumber, final int[] array) {
    if (counterNumber == 0) {
      return new int[0];
    }

    final int outputCounters[] = new int[counterNumber];
    int currentMaxValue = 0;

    for (int i = 0; i < array.length; i++) {
      final int currentArrayValue = array[i];

      if (currentArrayValue > 0) {
        if (currentArrayValue <= counterNumber) {
          // increase operation because 1 <= A[K] <= N
          // Due to the zero based index we need to use X-1
          outputCounters[currentArrayValue - 1] += 1;
          // Set new max value
          if (outputCounters[currentArrayValue - 1] > currentMaxValue) {
            currentMaxValue = outputCounters[currentArrayValue - 1];
          }
        } else if (currentArrayValue == counterNumber + 1) {
          // max counter operation because A[K] = N+1
          for (int j = 0; j < counterNumber; j++) {
            outputCounters[j] = currentMaxValue;
          }
        }
      }
      // Skip 0 value
      log(i, outputCounters);
    }

    return outputCounters;
  }

  private void log(final int roundNumber, final int[] outputCounter) {
    String log = "{";
    for (int i = 0; i < outputCounter.length; i++) {
      log += outputCounter[i];
      if (i + 1 < outputCounter.length) {
        log += ",";
      }
    }
    log += "}";

    LOGGER.debug(String.format("Round %2s : outputArray %s", roundNumber, log));
  }


}
