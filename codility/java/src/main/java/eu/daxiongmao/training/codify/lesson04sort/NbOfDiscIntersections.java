package eu.daxiongmao.training.codify.lesson04sort;

/**
 * To compute the "nb of disc intersections" algorithm.
 *
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class NbOfDiscIntersections {


    /** This is a bad solution, since the complexity is O(n²)
     * as well as the memory usage in O(2n). */
    public int badSolution(final Integer[] arrayToProcess) {
        Integer[][] circlesStartStop = getCirclesStartStopValues(arrayToProcess);

        for (int x = 0; x < arrayToProcess.length; x++) {
            System.out.println(printLog(x, circlesStartStop[x][0], circlesStartStop[x][1]));
        }


        // Process each point and search for differences
        // From X(0) to X(N) scan for row values that cross X(i).
        int totalIntersections = 0;
        for (int x = 0; x < arrayToProcess.length; x++) {
            System.out.println("\nProcessing X: " + x);
            int leftInter = 0;
            int rightInter = 0;

            for (int y = 0; y < arrayToProcess.length; y++) {
                // Check for intersections on the right side
                if (y >= (x +1) && circlesStartStop[y][0] <= x && circlesStartStop[y][1] >= x) {
                     rightInter++;
                    System.out.println(printLog(x, x, circlesStartStop[y][1]));
                } else {
                    System.out.println(" ");
                }
            }

            String log = String.format("X[%s] - %s left + %s right = %s intersections", x, leftInter, rightInter, leftInter + rightInter);
            System.out.println(log);
            totalIntersections += leftInter + rightInter;
        }

        return totalIntersections;
    }

    private String printLog(int x, int start, int stop) {
        String log = "";
        for (int i = 0; i <= stop; i++) {
            if (i < start) {
                log += " ";
            } else if (i == x) {
                log += ".";
            } else {
                log += "_";
            }
        }
        return log;
    }

     /** Extract start / stop point for each circle. */
     private Integer[][] getCirclesStartStopValues(final Integer[] arrayToProcess) {
        Integer[][] circlesStartStop = new Integer[arrayToProcess.length][2];
        for (int i = 0; i < arrayToProcess.length; i++) {
            // Min value == left side of the circle
            int minValue = i - arrayToProcess[i];
            if (minValue > 0) {
                circlesStartStop[i][0] = minValue;
            } else {
                circlesStartStop[i][0] = 0;
            }

            // Max value == right side of the circle
            int maxValue = i + arrayToProcess[i];
            if (maxValue < arrayToProcess.length) {
                circlesStartStop[i][1] = maxValue;
            } else {
                circlesStartStop[i][1] = arrayToProcess.length;
            }
        }
        return circlesStartStop;
    }
}
