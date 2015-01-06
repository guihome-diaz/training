package eu.daxiongmao.training.codify.lesson03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To process the "min average two slices" algorithm. <br>
 * see https://codility.com/demo/take-sample-test/min_avg_two_slice<br>
 * <br>
 * see also: http://codility-lessons.blogspot.se/2014/07/lesson-3-minavgtwoslice.html for
 * Explanations.
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class MinAverageTwoSlices {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MinAverageTwoSlices.class);

  /**
   * <strong>Mathematics explanation</strong><br>
   * <a href="http://codility-lessons.blogspot.se/2014/07/lesson-3-minavgtwoslice.html">
   * http://codility-lessons.blogspot.se/2014/07/lesson-3-minavgtwoslice.html</a> <br>
   * To check the number of the slots that produce the minimum average, we only have to check the
   * sum of the consecutive two or three slots.<br>
   * This can be said to any slice of an arbitrary size.<br>
   * <br>
   * If any sub-slice of a certain slice can produce a smaller average, then the original slice is
   * not the slice that can produce a smaller portion. It the average values of the original slice
   * and sub-slice are the same, we can simply take the index where the original slice starts, since
   * what we need to return is the smallest index.
   *
   * @param array array to process
   * @return starting position of the slice with the minimal average. <br>
   *         If there is more than one slice with a minimal average, the smallest starting position
   *         will be return.
   */
  public int solution(final int[] array) {
    // Assumptions: array not empty with, at least, 2 values
    if (array.length < 2) {
      return 0;
    }

    final int arraySize = array.length;

    // Compute initial conditions
    float minAverage = (float) (array[0] + array[1]) / 2;
    int minimumAverageIndex = 0;

    for (int i = 0; i < arraySize - 2; i++) {
      // Comparison using 2 values
      final float minAverage2slots = (float) (array[i] + array[i + 1]) / 2;
      if (minAverage2slots < minAverage) {
        minAverage = minAverage2slots;
        minimumAverageIndex = i;
      }

      // Comparison using 3 values
      final float minAverage3slots = (float) (array[i] + array[i + 1] + array[i + 2]) / 3;
      if (minAverage3slots < minAverage) {
        minAverage = minAverage3slots;
        minimumAverageIndex = i;
      }
    }

    // Compare last slice (A[n-1], A[n-2])
    if ((float) (array[arraySize - 2] + array[arraySize - 1]) / 2 < minAverage) {
      minimumAverageIndex = arraySize - 2;
    }

    return minimumAverageIndex;

  }

  /**
   * @deprecated this algo has a complexity O(n^2). Do not use it.
   */
  @Deprecated
  int slowSolution(final int[] array) {
    // Assumptions: array not empty with, at least, 2 values
    if (array.length < 2) {
      return 0;
    }

    // Max value is 10 000.
    // By starting with an unrealistic value the average will be set for sure!
    // To ensure the real average we must work with floats
    float minimumAverage = (float) 10001.00;

    // Starting point
    int minimumAverageIndex = 0;

    // Go through each possibilities using {P,Q} such as:
    // { A[i],A[i+1] ; A[i],A[length - 1] }
    // while A[i] has i < A[N-2]

    for (int startP = 0; startP < array.length - 1; startP++) {
      int sliceSum = array[startP];

      for (int endQ = startP + 1; endQ < array.length; endQ++) {
        sliceSum += array[endQ];
        final float average = (float) sliceSum / (endQ - startP + 1);

        String log = "Slice Sum(A[%s],A[%s])=%8s | average: %10.2f";
        log = String.format(log, startP, endQ, sliceSum, average);
        LOGGER.debug(log);

        if (average < minimumAverage) {
          minimumAverage = average;
          minimumAverageIndex = startP;
        }
      }
    }

    return minimumAverageIndex;
  }
}
