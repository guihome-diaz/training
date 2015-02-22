package eu.daxiongmao.training.codify.lesson03sum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To process the "passing cars" algorithm. <br>
 * see https://codility.com/demo/take-sample-test/passing_cars
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class PassingCars {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(PassingCars.class);

  /**
   * @param carArray list of cars driving by
   * @return number of passing cars
   */
  public int solution(final int[] carArray) {
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
