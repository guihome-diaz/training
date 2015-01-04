package eu.daxiongmao.training.codify.lesson01;

public class Frog {

  /**
   * This solution is slightly faster than the previous one. <br/>
   * It is 0.1% more fast...
   *
   * @param startPoint start point
   * @param endPoint final point. It must be more than start point otherwise nothing will happen
   *        (returns 0)
   * @param jumpSize jump size. it must be > 0
   * @return the number of jumps that are required to do through the next step
   */
  public int fastSolution(final int startPoint, final int endPoint, final int jumpSize) {
    // Enforce conditions
    if (startPoint >= endPoint) {
      return 0;
    }
    if (jumpSize <= 0) {
      throw new IllegalArgumentException("You cannot achieve to a solution if jumps are <= 0");
    }

    // Hint: in java you must cast one of the element in float to get a float back...
    int numberOfJumps = (endPoint - startPoint) / jumpSize;
    if (((endPoint - startPoint) % jumpSize) > 0) {
      numberOfJumps++;
    }
    return numberOfJumps;
  }

  /**
   * @deprecated Even though this solution is good and working it is 0.1% too slow compare to the
   *             modulo version.
   */
  @Deprecated
  int slowSolution(final int startPoint, final int endPoint, final int jumpSize) {
    // Enforce conditions
    if (startPoint >= endPoint) {
      return 0;
    }
    if (jumpSize <= 0) {
      throw new IllegalArgumentException("You cannot achieve to a solution if jumps are <= 0");
    }

    // Hint: in java you must cast one of the element in float to get a float back...
    final float numberOfJumps = (float) (endPoint - startPoint) / jumpSize;
    return (int) Math.ceil(numberOfJumps);
  }


}
