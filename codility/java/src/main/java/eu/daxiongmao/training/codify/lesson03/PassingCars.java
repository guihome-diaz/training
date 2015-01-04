package eu.daxiongmao.training.codify.lesson03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PassingCars {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(PassingCars.class);

  /**
   * <p>
   * This solves the following algorithm:<br/>
   * A non-empty zero-indexed array A consisting of N integers is given. <br/>
   * The consecutive elements of array A represent consecutive cars on a road.<br/>
   * <br/>
   * Array A contains only 0s and/or 1s:
   * <ul>
   * <li>0 represents a car traveling east</li>
   * <li>1 represents a car traveling west</li>
   * </ul>
   * The goal is to count passing cars. <br/>
   * We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the
   * east and Q is traveling to the west.
   * </p>
   * <p>
   * This function must returns the number of passing cars.<br/>
   * Assume that:
   * <ul>
   * <li>function should return −1 if the number of passing cars exceeds 1,000,000,000</li>
   * <li>N is an integer within the range [1..100,000]</li>
   * <li>each element of array A is an integer that can have one of the following values: 0, 1</li>
   * </ul>
   * </p>
   * <hr/>
   * <p>
   * For example, consider array A such that:<br/>
   * A[] = {0,1,0,1,1}<br/>
   * We have 5 pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
   * </p>
   * 
   * @param carArray list of cars driving by
   * @return number of passing cars
   */
  public int countPassingCars(final int[] carArray) {
    final int totalCars = carArray.length;

    int sumCarsTravelingWest = 0;
    int sumCarCrossing = 0;

    // Step 1: count the number of cars going west (1)
    for (int i = 0; i < totalCars; i++) {
      if (carArray[i] == 1) {
        sumCarsTravelingWest++;
      }
    }

    // Step 2: processing crossings with cars going east (0)
    for (int i = 0; i < totalCars; i++) {
      if (carArray[i] == 0) {
        sumCarCrossing += sumCarsTravelingWest;
        // Ensure we didn't reach the max. value
        if (sumCarCrossing > 1000000000) {
          LOGGER.error("Too many car crossing!! Breaking count at index i=" + i);
          sumCarCrossing = -1;
          break;
        }
      } else {
        sumCarsTravelingWest--;
      }
    }

    return sumCarCrossing;
  }
}
