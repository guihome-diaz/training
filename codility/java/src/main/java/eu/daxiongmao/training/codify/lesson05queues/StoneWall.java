package eu.daxiongmao.training.codify.lesson05queues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * To count the min. number of rectangles required to build a specific "skyline"..
 *
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class StoneWall {

    public int countRectangles(final int[] wallHeights) {
        // Principle: put in queue all + height ; count the number of square on - height
        final Deque<Integer> heights = new ArrayDeque<>();

        int nbOfRectangles = 0;

        for (int currentHeight : wallHeights) {
            // Start condition
            if (heights.isEmpty()) {
                heights.push(currentHeight);
                continue;
            }

            // Up change
            if (currentHeight > heights.peek()) {
                heights.push(currentHeight);
                continue;
            }

            // Down change
            if (currentHeight < heights.peek()) {
                // Compare with previous values
                while (!heights.isEmpty() && currentHeight < heights.peek()) {
                    nbOfRectangles++;
                    heights.poll();
                }
                // Save current value with duplicate avoidance
                if (! heights.contains(currentHeight)) {
                    heights.push(currentHeight);
                }
            }
        }

        // Count the rest
        while (!heights.isEmpty()) {
            heights.poll();
            nbOfRectangles++;
        }

        return nbOfRectangles;
    }

}
