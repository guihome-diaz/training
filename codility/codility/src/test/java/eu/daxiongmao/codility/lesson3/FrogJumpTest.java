package eu.daxiongmao.codility.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrogJumpTest {

    FrogJump service = new FrogJump();

    @Test
    @DisplayName("Frog jumps")
    public void jump() {
        Assertions.assertEquals(0, service.getNumberOfJumps(10, 10, 30));
        Assertions.assertEquals(5, service.getNumberOfJumps(10, 60, 10));
        Assertions.assertEquals(6, service.getNumberOfJumps(10, 61, 10));
        Assertions.assertEquals(3, service.getNumberOfJumps(10, 85, 30));
    }
}
