package eu.daxiongmao.training.codify.lesson01;

import org.junit.Assert;
import org.junit.Test;

public class FrogJumpTest {

  @Test
  public void jumpTest() {
    final int startPoint = 10;
    final int endPoint = 85;
    final int jumpSize = 30;

    final FrogJump algo = new FrogJump();
    final int resultFast = algo.fastSolution(startPoint, endPoint, jumpSize);

    Assert.assertEquals(3, resultFast);
  }

  @Test
  public void badStartEnd() {
    final int startPoint = 40;
    final int endPoint = 15;
    final int jumpSize = 5;

    final FrogJump algo = new FrogJump();
    final int resultFast = algo.fastSolution(startPoint, endPoint, jumpSize);

    Assert.assertEquals(0, resultFast);
  }

  @Test
  public void noJumpRequired() {
    final int startPoint = 10;
    final int endPoint = 10;
    final int jumpSize = 30;

    final FrogJump algo = new FrogJump();
    final int resultFast = algo.fastSolution(startPoint, endPoint, jumpSize);

    Assert.assertEquals(0, resultFast);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noJumpsFast() {
    final int startPoint = 10;
    final int endPoint = 85;
    final int jumpSize = 0;

    final FrogJump algo = new FrogJump();
    algo.fastSolution(startPoint, endPoint, jumpSize);

    // You should NOT reach that code!
    Assert.fail();
  }

  @Test(expected = IllegalArgumentException.class)
  public void backwardsJumpsFast() {
    final int startPoint = 10;
    final int endPoint = 85;
    final int jumpSize = -20;

    final FrogJump algo = new FrogJump();
    algo.fastSolution(startPoint, endPoint, jumpSize);

    // You should NOT reach that code!
    Assert.fail();
  }
}
