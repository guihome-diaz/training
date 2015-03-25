package eu.daxiongmao.training.codify.lesson06leader;


import eu.daxiongmao.training.codify.utils.FoundLeader;

public class Dominator {

    /**
     * To find the leader of the given sequence and return its first occurrence in the given array
     * @param sourceArray the array to analyze
     * @return index of the first occurrence of the leader value || -1 if there is no leader
     */
    public int solution(final int[] sourceArray) {
        final int leader = FoundLeader.foundLeader(sourceArray);

        int leaderPositionInArray = -1;
        if (leader > -1) {
            for (int i = 0; i < sourceArray.length; i++) {
                if (sourceArray[i] == leader) {
                    leaderPositionInArray = i;
                    break;
                }
            }
        }
        return leaderPositionInArray;
    }

}
