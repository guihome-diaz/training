package eu.daxiongmao.training.codify.lesson02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To process the "max counters" algorithm. <br>
 * see https://codility.com/demo/take-sample-test/max_counters
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class MaxCounters {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MaxCounters.class);

  /**
   * @param counterNumber number of counter to create in the output array. <br>
   *        This also set the limit between increase | max counter operations
   * @param array array to analyze
   * @return new array with output results
   */
  public int[] solution(final int counterNumber, final int[] array) {
    if (counterNumber == 0) {
      return new int[0];
    }

    final int outputCounters[] = new int[counterNumber];
    int currentMaxValue = 0;
    int currentMinValue = 0;

    // Populate max and high values
    for (int i = 0; i < array.length; i++) {
      final int currentArrayValue = array[i];

      if (currentArrayValue > 0) {
        if (currentArrayValue <= counterNumber) {
          // increase operation
          // Trick: we need to check the min value as well
          // !! Due to the zero based index we need to use X-1
          if (outputCounters[currentArrayValue - 1] < currentMinValue) {
            outputCounters[currentArrayValue - 1] = currentMinValue + 1;
          } else {
            outputCounters[currentArrayValue - 1] += 1;
          }

          // Set new max value
          if (outputCounters[currentArrayValue - 1] > currentMaxValue) {
            currentMaxValue = outputCounters[currentArrayValue - 1];
          }
        } else if (currentArrayValue == counterNumber + 1) {
          // max counter operation because A[K] = N+1
          // Set new min value
          currentMinValue = currentMaxValue;
        }
      }
      // Skip 0 value
    }

    // Set minimum values
    for (int i = 0; i < counterNumber; i++) {
      if (outputCounters[i] < currentMinValue) {
        outputCounters[i] = currentMinValue;
      }
    }

    return outputCounters;
  }

  /**
   * @deprecated this is not as efficient as it should be. Do not use it!
   */
  @Deprecated
  int[] slowSolution(final int counterNumber, final int[] array) {
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
