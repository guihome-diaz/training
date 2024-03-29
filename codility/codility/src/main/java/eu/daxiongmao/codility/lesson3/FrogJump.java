package eu.daxiongmao.codility.lesson3;

/**
 * Frog jump exercise
 * @author Guillaume
 * @version 2021/06
 */
public class FrogJump {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 1000000000;

    public int getNumberOfJumps(final int startPointX, final int targetPointY, final int jumpSize) {
        // args check
        // *************************
        if (isInvalidInput(startPointX) && isInvalidInput(targetPointY) && isInvalidInput(jumpSize)) {
            throw new IllegalArgumentException("At least one of the argument is not within the range [" + MIN_VALUE + ".." + MAX_VALUE + "]");
        }
        if (startPointX > targetPointY) { throw new IllegalArgumentException("A frog can only jump further, not backwards"); }

        // algo
        // *************************
        // No jump required
        if (startPointX == targetPointY) { return 0; }

        // Do computation
        int distanceToJump = targetPointY - startPointX;
        int numberOfJumpRequired = (distanceToJump / jumpSize);
        boolean hasRemainingDistance = (distanceToJump % jumpSize != 0);

        return  numberOfJumpRequired + (hasRemainingDistance ? 1 : 0);
    }

    private boolean isInvalidInput(int input) {
        return ! (input >= MIN_VALUE && input <= MAX_VALUE);
    }

}
