package eu.daxiongmao.training.codify.lesson03sum;

/**
 * To process the "count div" algorithm. <br>
 * see https://codility.com/demo/take-sample-test/count_div
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class CountDiv {

  /**
   * @param startRange <strong>A</strong> | start value (include in analyze)
   * @param endRange <strong>B</strong> | end value (include in analyze)
   * @param modulo <strong>K</strong> | modulo value
   * @return number of integers within the range [A...B] that can be divided by K
   */
  public int solution(final int startRange, final int endRange, final int modulo) {
    int counter = 0;

    // Handle 0 case. 0 can be divided by any number !
    if (startRange == 0) {
      counter++;
    }
    // check conditions
    if (modulo > endRange) {
      return counter;
    }

    // Compute changes
    if (modulo > startRange) {
      counter += endRange / modulo;
    } else if (modulo <= startRange) {
      // End state - initial state
      // (B/K) - ((A-1) / K)
      counter += (endRange / modulo) - (startRange - 1) / modulo;
    }

    return counter;
  }

  /**
   * @deprecated This algo has a complexity of O(n). Expected complexity is O(1)...
   */
  @Deprecated
  int slowSolution(final int startRange, final int endRange, final int modulo) {
    // check conditions
    if (modulo > endRange) {
      if (startRange > 0) {
        return 0;
      } else {
        return 1;
      }
    }

    int counter = 0;

    // Count values
    for (int currentValue = startRange; currentValue <= endRange; currentValue++) {
      if (currentValue % modulo == 0) {
        counter++;
      }
    }

    return counter;
  }

}
