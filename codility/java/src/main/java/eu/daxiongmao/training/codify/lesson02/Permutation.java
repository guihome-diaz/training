package eu.daxiongmao.training.codify.lesson02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Permutation {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(Permutation.class);

  /**
   * To check if the given array is a <i>permutation</i> or not. <br>
   * A permutation array is:
   * <ul>
   * <li>A <strong>sequence</strong> with all values from 1 to array.length</li>
   * <li>Every number is only written once</li>
   * </ul>
   *
   * @param array array to analyze
   * @return boolean true (1) if the given array is a <i>permutation</i><br/>
   *         False (0) otherwise
   */
  public int solution(final int[] array) {
    // Check initial conditions
    if (array == null || array.length == 0) {
      // Missing value "1"
      return 0;
    }

    final int[] tempSequence = new int[array.length + 1];
    int result = 1;

    // Step 1: populate the sequence array
    for (int i = 0; i < array.length; i++) {
      // Check limits
      if (array[i] >= array.length + 1) {
        LOGGER.debug(String.format(
            "One of the value is out of bound! Max value: %s | current value: %s",
            array.length + 1, array[i]));
        return 0;
      }

      tempSequence[array[i]] += 1;
    }

    // Step 2: check that no number is missing from 1 to N
    for (int i = 1; i <= array.length; i++) {
      if (tempSequence[i] != 1) {
        // Failure: missing or duplicate
        LOGGER.debug("This is NOT a permutation! Value " + i + " is missing or duplicate");
        result = 0;
        break;
      }
    }

    return result;
  }
}
