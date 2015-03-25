package eu.daxiongmao.training.codify.utils;

import org.junit.Assert;
import org.junit.Test;

public class FoundLeaderTest {


    @Test
    public void foundLeaderBasic() {
        final int[] sourceArray = new int[] {4, 6, 6, 6, 6, 8, 8};
        final int leader = FoundLeader.foundLeader(sourceArray);

        Assert.assertEquals(6, leader);
    }

    @Test
    public void foundLeaderExercice1() {
        final int[] sourceArray = new int[] {4, 3, 4, 4, 4, 2};
        final int leader = FoundLeader.foundLeader(sourceArray);

        Assert.assertEquals(4, leader);
    }


    @Test
    public void foundLeaderExercice2() {
        final int[] sourceArray = new int[] {3, 4, 3, 2, 3, -1, 3, 3};
        final int leader = FoundLeader.foundLeader(sourceArray);

        Assert.assertEquals(3, leader);
    }


    @Test
    public void foundLeaderNoLeader() {
        final int[] sourceArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        final int leader = FoundLeader.foundLeader(sourceArray);

        Assert.assertEquals(-1, leader);
    }


    @Test
    public void foundLeaderNoLeaderButAlmost() {
        final int[] sourceArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8};
        final int leader = FoundLeader.foundLeader(sourceArray);

        Assert.assertEquals(-1, leader);
    }

}
