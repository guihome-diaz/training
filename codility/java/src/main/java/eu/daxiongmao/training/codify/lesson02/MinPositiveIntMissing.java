package eu.daxiongmao.training.codify.lesson02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MinPositiveIntMissing {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MinPositiveIntMissing.class);

  /**
   * To look for the minimal positive integer missing in the given array.<br/>
   * As a reminder, positive integers start at value "1".<br/>
   * <br/>
   * This solution is using an algorithm performance O(n)
   *
   * @param array the array to inspect. This array can have values from Integer.MIN to Integer.MAX
   * @return the minimal positive integer that is missing, starting at 1.
   */
  int getMissingPositiveInteger(final int[] array) {
    // Check arguments
    if (array.length == 0) {
      return 1;
    }

    // FIXME transform that into O(n) instead of O(n^2)

    // Look for minimal value
    // This is O(n^2)
    boolean minValueFound;
    int minValue = 1;
    do {
      minValueFound = false;
      for (int i = 0; i < array.length; i++) {
        if (array[i] == minValue) {
          minValue++;
          minValueFound = true;
          break;
        }
      }
    } while (minValueFound);

    return minValue;
  }

  /**
   * To look for the minimal positive integer missing in the given array.<br/>
   * As a reminder, positive integers start at value "1".
   *
   * @param array the array to inspect. This array can have values from Integer.MIN to Integer.MAX
   * @return the minimal positive integer that is missing, starting at 1.
   * @deprecated do not use that function! It's too slow.<br/>
   *             This is an algorithm performance O(n^2)
   */
  @Deprecated
  int getMissingPositiveInteger_slowAlgo(final int[] array) {
    // Check arguments
    if (array.length == 0) {
      return 1;
    }

    // Look for minimal value
    // This is O(n^2)
    boolean minValueFound;
    int minValue = 1;
    do {
      minValueFound = false;
      for (int i = 0; i < array.length; i++) {
        if (array[i] == minValue) {
          minValue++;
          minValueFound = true;
          break;
        }
      }
    } while (minValueFound);

    return minValue;
  }


}
