package eu.daxiongmao.training.codify.lesson03;

public class CountDiv {

  /**
   * <p>
   * This resolve the following algorithm:<br/>
   * Counts and returns the number of integers within the range [A..B] that are divisible by K.<br/>
   * ie: <strong>{ i: A ≤ i ≤ B, i % K = 0 }</strong>
   * </p>
   * <p>
   * Assume that:
   * <ul>
   * <li>A and B are integers within the range [0..2,000,000,000]</li>
   * <li>K is an integer within the range [1..2,000,000,000]</li>
   * <li>A ≤ B</li>
   * </ul>
   * </p>
   * <p>
   * This algo must have a complexity of O(1)
   * </p>
   * <hr/>
   * <p>
   * For example: <br/>
   * A = 6, B = 11 and K = 2<br/>
   * expected return value: 3<br/>
   * because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
   * </p>
   *
   * @param startRange <strong>A</strong> | start value (include in analyze)
   * @param endRange <strong>B</strong> | end value (include in analyze)
   * @param modulo <strong>K</strong> | modulo value
   * @return number of integers within the range [A...B] that can be divided by K
   */
  public int countDiv(final int startRange, final int endRange, final int modulo) {
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
  int countDiv_slowAlgo(final int startRange, final int endRange, final int modulo) {
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
