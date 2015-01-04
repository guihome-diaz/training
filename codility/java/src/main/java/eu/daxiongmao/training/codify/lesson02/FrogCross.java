package eu.daxiongmao.training.codify.lesson02;


public class FrogCross {

  /**
   * <p>
   * To compute how much time it will take to the frog to cross the river. <br/>
   * Result time depends on the available leaves and their time.<br/>
   * Each minute a new leaf is available. <br/>
   * Leaves and time are represented in array[minute]=leaf_index
   * </p>
   * <p>
   * This version deals with COMPUTER logic. That means it <strong>based on 0...X-1</strong><br/>
   * Performance wised that is a bit better
   * </p>
   *
   * @param riverSize total river size
   * @param leavesTime Each minute a new leaf is available. <br/>
   *        Leaves and time are represented in array[minute]=leaf_index
   * @return -1 if the frog cannot cross the river || else the required time in minute
   */
  public int crossRiver(final int riverSize, final int[] leavesTime) {
    // Check args
    if (leavesTime == null || leavesTime.length == 0) {
      return -1;
    }
    if (riverSize == 0) {
      return 0;
    }

    // Default result is 'not possible'
    int result = -1;
    int currentPosition = 0;

    // Array starting at 0...(riverSize - 1)
    final int currentLeaves[] = new int[riverSize];

    for (int i = 0; i < leavesTime.length; i++) {
      // Register the current leave as fallen (!! Computer logic you should think of array
      // restriction !!)
      currentLeaves[leavesTime[i] - 1] = 1;

      if (leavesTime[i] == currentPosition + 1) {
        // Frog can move!
        currentPosition++;
        // Check for other available moves as well
        while (currentPosition < riverSize && currentLeaves[currentPosition] == 1) {
          currentPosition++;
        }
        // Is the river crossed ?
        if (currentPosition == riverSize) {
          result = i;
          break;
        }
      }
    }

    return result;
  }

  /**
   * @deprecated do not use that function since it uses a bit too much memory
   */
  @Deprecated
  int crossRiver_humanLogic(final int riverSize, final int[] leavesTime) {
    // Check args
    if (leavesTime == null || leavesTime.length == 0) {
      return -1;
    }
    if (riverSize == 0) {
      return 0;
    }

    // Default result is 'not possible'
    int result = -1;
    int currentPosition = 0;

    // Array starting at 0 (but not used). Real values from 1...riverSize
    final int currentLeaves[] = new int[riverSize + 1];

    for (int i = 0; i < leavesTime.length; i++) {
      // Register the current leave as fallen
      currentLeaves[leavesTime[i]] = 1;

      if (leavesTime[i] == currentPosition + 1) {
        // Frog can move!
        currentPosition++;
        // Check for other available moves as well (!! Human logic array must be adjusted !!)
        while (currentPosition < riverSize && currentLeaves[currentPosition + 1] == 1) {
          currentPosition++;
        }
        // Is the river crossed ?
        if (currentPosition == riverSize) {
          result = i;
          break;
        }
      }
    }

    return result;
  }



}
