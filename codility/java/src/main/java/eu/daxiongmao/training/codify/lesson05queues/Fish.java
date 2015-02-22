package eu.daxiongmao.training.codify.lesson05queues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * To count the number of survival fish down the river.
 *
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class Fish {

    /**
     * Hypothesis: every fish has a different size.<br>
     *     Otherwise this algo will always favor the downstream fish.
     * @param fishSize array that describes the size of each fish
     * @param fishStream array that represents the direction of each fish
     * @return the number of fish that cross the river
     */
    public int countFish(final int fishSize[], final int fishStream[]) {
        int upstreamFishSafe = 0;
        Deque<Integer> downstreamFish = new ArrayDeque<>();

        // Process encounters
        for (int i = 0; i < fishSize.length; i++) {
            // Upstream fish
            if (fishStream[i] == 0) {
                // Check against all fish that are going the other way (inspect HEAD first)
                while (downstreamFish.size() > 0 && fishSize[i] > downstreamFish.peek()) {
                    downstreamFish.poll();
                }
                // No downstream fish or the current upstream fish eat them all!
                if (downstreamFish.size() == 0) {
                    upstreamFishSafe++;
                }
            } else {
                // Downstream fish. Add it to the TAIL of the queue
                downstreamFish.add(fishSize[i]);
            }
        }

        return downstreamFish.size() + upstreamFishSafe;
    }


}
