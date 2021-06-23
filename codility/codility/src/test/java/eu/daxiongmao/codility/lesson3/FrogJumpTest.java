package eu.daxiongmao.codility.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrogJumpTest {

    FrogJump service = new FrogJump();

    @Test
    @DisplayName("Frog jumps")
    public void jump() {
        Assertions.assertEquals(3, service.getNumberOfJumps(10, 85, 30));
    }
}
