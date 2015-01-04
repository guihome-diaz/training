package eu.daxiongmao.training.codify.lesson02;



public class MinPositiveIntMissing {

  /**
   * To look for the minimal positive integer missing in the given array.<br/>
   * As a reminder, positive integers start at value "1".<br/>
   * <br/>
   * This solution is using an algorithm performance O(n)
   *
   * @param array the array to inspect. This array can have values from Integer.MIN to Integer.MAX
   * @return the minimal positive integer that is missing, starting at 1.
   */
  public int getMissingPositiveInteger(final int[] array) {
    // Check arguments
    if (array.length == 0) {
      return 1;
    }

    final int arraySize = array.length;

    // Since array.length is limited to 1 000 000 ; while each value varies from (-) Integer.MAX
    // The missing integer must be within [0...array.length]
    // In worst case, if the array is a suite, then the missing integer will be (array.length + 1)

    // According to these previous statements: we can use a count array
    // Value "1" is represented in countArray[0]
    final int countArray[] = new int[arraySize];


    // Step 1: populate countArray
    for (int i = 0; i < arraySize; i++) {
      // Ignore negative and out-of-range values
      if (array[i] > 0 && array[i] <= arraySize) {
        // Save value in X-1 due to array zero index
        countArray[array[i] - 1] = 1;
      }
    }

    // Step 2: check for missing values
    int minValue = 1;
    for (int i = 0; i < arraySize; i++) {
      if (countArray[i] == 0) {
        // Missing value has been found!
        break;
      } else {
        // Increase next minimum value
        minValue++;
      }
    }

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
