package eu.daxiongmao.training.codify.utils;

/**
 * To find the leader in a sequence of integer.<br/>
 * A "leader" is the element that occurs more than N/2 times where N = array size.<br/>
 * <br/>
 * This code is based on Codility lesson 6 "leader" pseudo-code.
 */
public final class FoundLeader {

    // Private factory
    private FoundLeader() { }

    /**
     * If the given array contains a leader, then after removing a <i>pair of element of different values</i>
     * the remaining sequence still has the same leader. <br/>
     * This result in a <code>2 * O(n)</code> algorithm complexity, which is very efficient!
     * @param sourceArray the array to process
     * @return
     * <ul>
     *     <li>the leader value, if found</li>
     *     <li><code>-1</code> if there is no leader value == no value occurring more than N/2 times</li>
     * </ul>
     */
    public static int foundLeader(final int[] sourceArray) {
        // Find element with most occurrences
        int leaderCandidate = findElementWithMostOccurences(sourceArray);

        int leader = -1;
        if (leaderCandidate > -1) {
            // Is this element a "leader" ?
            int count = 0;
            for (int currentValue : sourceArray) {
                if (currentValue == leaderCandidate) {
                    count++;
                }
            }
            if (count > sourceArray.length / 2) {
                leader = leaderCandidate;
            }
        }

        return leader;
    }

    /**
     * To find the element that occurs the most - if any.
     * @param sourceArray the array to analyze
     * @return
     * <ul>
     *     <li>the element that occurs the most</li>
     *     <li><code>-1</code> otherwise == if there is no element that occurs more than the others</li>
     * </ul>
     */
    private static int findElementWithMostOccurences(final int[] sourceArray) {
        // Find element with most occurrences
        int stackSize = 0;
        int elementWithMostOccurrences = 0;
        for (int currentValue : sourceArray) {
            if (stackSize == 0) {
                stackSize++;
                elementWithMostOccurrences = currentValue;
            } else {
                if (elementWithMostOccurrences != currentValue) {
                    stackSize--;
                } else {
                    stackSize++;
                }
            }
        }

        // Is there a "leader" candidate?
        int leaderCandidate = -1;
        if (stackSize > 0) {
            leaderCandidate = elementWithMostOccurrences;
        }

        return leaderCandidate;
    }

}
