package eu.daxiongmao.training.codify.lesson06leader;


import org.junit.Assert;
import org.junit.Test;

public class DominatorTest {

    @Test
    public void exampleDataSetTest() {
        final int[] sourceArray = new int[] {3, 4, 3, 2, 3, -1, 3, 3};
        Dominator algo = new Dominator();
        final int leaderFirstOccurence = algo.solution(sourceArray);
        Assert.assertEquals(0, leaderFirstOccurence);
    }

    @Test
    public void exampleNoLeader() {
        final int[] sourceArray = new int[] {3, 4, 2, 3, -1, 3};
        Dominator algo = new Dominator();
        final int leaderFirstOccurence = algo.solution(sourceArray);
        Assert.assertEquals(-1, leaderFirstOccurence);
    }

    @Test
    public void alternateExample() {
        final int[] sourceArray = new int[] {1, 5, 7, 6, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Dominator algo = new Dominator();
        final int leaderFirstOccurence = algo.solution(sourceArray);
        Assert.assertEquals(6, leaderFirstOccurence);
    }

}
