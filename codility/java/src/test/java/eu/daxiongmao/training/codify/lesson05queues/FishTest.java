package eu.daxiongmao.training.codify.lesson05queues;


import org.junit.Assert;
import org.junit.Test;

public class FishTest {

    @Test
    public void exampleDataTest() {
        final int[] fishSize = new int[] {4, 3, 2, 1, 5};
        final int[] fishStream = new int[] {0, 1, 0, 0, 0} ;

        final Fish algo = new Fish();
        final int survivalFish = algo.countFish(fishSize, fishStream);

        Assert.assertEquals(2, survivalFish);
    }

    @Test
    public void river1Test() {
        final int[] fishSize = new int[] {2, 5, 7, 9, 1, 4, 11, 3};
        final int[] fishStream = new int[] {0, 1, 0, 1, 0, 0, 0, 1} ;

        final Fish algo = new Fish();
        final int survivalFish = algo.countFish(fishSize, fishStream);

        Assert.assertEquals(4, survivalFish);
    }

    @Test
    public void river2Test() {
        final int[] fishSize = new int[] {8, 2, 3, 9, 10, 7, 12, 1};
        final int[] fishStream = new int[] {1, 0, 0, 0, 1, 0, 1, 0} ;

        final Fish algo = new Fish();
        final int survivalFish = algo.countFish(fishSize, fishStream);

        Assert.assertEquals(3, survivalFish);
    }

    @Test
    public void river2BigUpstreamTest() {
        final int[] fishSize = new int[] {8, 2, 3, 9, 10, 7, 12, 1, 24};
        final int[] fishStream = new int[] {1, 0, 0, 0, 1, 0, 1, 0, 0} ;

        final Fish algo = new Fish();
        final int survivalFish = algo.countFish(fishSize, fishStream);

        Assert.assertEquals(2, survivalFish);
    }

    @Test
    public void river2MediumUpstreamTest() {
        final int[] fishSize = new int[] {8, 2, 3, 9, 10, 7, 12, 1, 11};
        final int[] fishStream = new int[] {1, 0, 0, 0, 1, 0, 1, 0, 0} ;

        final Fish algo = new Fish();
        final int survivalFish = algo.countFish(fishSize, fishStream);

        Assert.assertEquals(2, survivalFish);
    }
}
