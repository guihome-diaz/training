package eu.daxiongmao.training.codify.lesson01;

/**
 * To process perm. missing element algorithm. <br>
 * see https://codility.com/demo/take-sample-test/perm_missing_elem
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class PermMissingElement {

  /**
   * <p>
   * To check for a missing element within the values of the given array. <br/>
   * The given array values must be between 1 and N+1 (where N = array.length)<br/>
   * One of the element is missing.
   * </p>
   *
   * @param array the array to analyze
   * @return the missing element, starting at value 1.
   */
  public int solution(final int[] array) {
    if (array.length == 0) {
      // Careful! The first value expected is 1, not 0!!
      return 1;
    }

    int missingElement = 0;

    // Step 1: mark all the values that are OK (true == 1)
    final int orderedArray[] = new int[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      // Since the values start to 1, storage needs to be in array X-1
      orderedArray[array[i] - 1] = 1;
    }

    // Step 2: look for the missing value (default false ==0)
    for (int i = 0; i < orderedArray.length; i++) {
      if (orderedArray[i] == 0) {
        // Since the index is X-1, we must return X+1
        missingElement = i + 1;
        break;
      }
    }

    return missingElement;
  }
}
