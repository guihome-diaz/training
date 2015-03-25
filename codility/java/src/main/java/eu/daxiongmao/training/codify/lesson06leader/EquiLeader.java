package eu.daxiongmao.training.codify.lesson06leader;


import eu.daxiongmao.training.codify.utils.FoundLeader;

public class EquiLeader {

    /**
     * To count the number of equi-leader in the given source array.<br/>
     * For some equi-leader to be found:
     * <ul>
     *     <li>The given array must have a leader</li>
     *     <li>All equi-leader will have the same leader as the array</li>
     *     <li>Max number of equi-leader suites is N/2</li>
     * </ul>
     * @param sourceArray the array to analyze
     * @return the number of equi-leader, if any. Else returns 0
     */
    public int solution(final int[] sourceArray) {
        // Find the array leader
        final int arrayLeader = FoundLeader.foundLeader(sourceArray);
        if (arrayLeader == -1) {
            return 0;
        }

        // Count the number of leader occurrences in total & for each index until N/2
        int arrayHalfSize = sourceArray.length / 2;
        int nbOfLeaderOccurrencesInTotal = 0;
        int[] nbOfLeaderOccurrencesAtIndex = new int[arrayHalfSize];
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] == arrayLeader) {
                nbOfLeaderOccurrencesInTotal++;
                if (i < arrayHalfSize) {
                    nbOfLeaderOccurrencesAtIndex[i] = nbOfLeaderOccurrencesInTotal;
                }
            }
        }


        // Check results
        int nbOfEquiLeaders = 0;
        for (int i = 0; i < nbOfLeaderOccurrencesAtIndex.length; i++) {
            if (nbOfLeaderOccurrencesAtIndex[i] > 0) {
                int leftNbOfOccurrences = nbOfLeaderOccurrencesAtIndex[i];
                int rightNbOfOccurrences = nbOfLeaderOccurrencesInTotal - leftNbOfOccurrences;
                if (leftNbOfOccurrences > i / 2 && rightNbOfOccurrences > (sourceArray.length - 1 - i) / 2) {
                    nbOfEquiLeaders++;
                }
            }
        }

        return  nbOfEquiLeaders;
    }

}
