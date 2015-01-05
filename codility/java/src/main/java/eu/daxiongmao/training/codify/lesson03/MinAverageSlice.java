package eu.daxiongmao.training.codify.lesson03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinAverageSlice {

  /** Class logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MinAverageSlice.class);

  /**
   * <p>
   * This resolves the following algorithm: <br>
   * <ul>
   * <li>A non-empty zero-indexed array A consisting of N integers is given.</li>
   * <li>A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A <br>
   * ... (notice that the slice contains at least two elements).</li>
   * </ul>
   * The average of a slice (P, Q) is:<br>
   * <ul>
   * <li>sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.<br>
   * To be precise, the average equals: <strong>(A[P] + A[P + 1] + ... + A[Q]) / (Q − P +
   * 1)</strong></li>
   * </ul>
   * </p>
   * <p>
   * For example, given array A such that:<br>
   * A[] = {4, 2, 2, 5, 1, 5, 8}<br>
   * <br>
   * This array contains the following example slices, among others:
   * <ul>
   * <li>slice (1, 2), whose average is (2 + 2) / 2 = 2</li>
   * <li>slice (3, 4), whose average is (5 + 1) / 2 = 3</li>
   * <li>slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5</li>
   * </ul>
   * The minimum slice has an average of 1.
   * </p>
   * <p>
   * <strong>The goal is to find the starting position of a slice whose average is minimal.</strong>
   * </p>
   * <p>
   * Assume that:
   * <ul>
   * <li>N is an integer within the range [2..100,000]</li>
   * <li>each element of array A is an integer within the range [−10,000..10,000]</li>
   * </ul>
   * </p>
   * <p>
   * Expectations:
   * <ul>
   * <li>expected worst-case time complexity is O(N)</li>
   * <li>expected worst-case space complexity is O(N), beyond input storage</li>
   * </ul>
   * </p>
   *
   * @param array array to process
   * @return starting position of the slice with the minimal average. <br>
   *         If there is more than one slice with a minimal average, the smallest starting position
   *         will be return.
   */
  public int getMinAverageSlice(final int[] array) {
    // Assumptions: array not empty with, at least, 2 values
    if (array.length < 2) {
      return 0;
    }

    /*
     * Mathematics explanation:
     * http://codility-lessons.blogspot.se/2014/07/lesson-3-minavgtwoslice.html
     *
     * To check the number of the slots that produce the minimum average, we only have to check the
     * sum of the consecutive two or three slots.
     *
     * This can be said to any slice of an arbitrary size.
     *
     * If any sub-slice of a certain slice can produce a smaller average, then the original slice is
     * not the slice that can produce a smaller portion. It the average values of the original slice
     * and sub-slice are the same, we can simply take the index where the original slice starts,
     * since what we need to return is the smallest index.
     */

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
  int getMinAverageSlice_slowAlgo(final int[] array) {
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
