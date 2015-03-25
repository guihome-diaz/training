package eu.daxiongmao.training.codify.lesson06leader;

import org.junit.Assert;
import org.junit.Test;

public class EquiLeaderTest {

    @Test
    public void exampleDatasetTest() {
        final int[] sourceArray = new int[] {4, 3, 4, 4, 4, 2};
        final EquiLeader algo = new EquiLeader();

        final int nbOfEquiLeader = algo.solution(sourceArray);
        Assert.assertEquals(2, nbOfEquiLeader);
    }

    @Test
    public void noLeader() {
        final int[] sourceArray = new int[] {1, 3, 4, 4, 4, 2};
        final EquiLeader algo = new EquiLeader();

        final int nbOfEquiLeader = algo.solution(sourceArray);
        Assert.assertEquals(0, nbOfEquiLeader);
    }

    @Test
    public void noEquiLeader() {
        final int[] sourceArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        final EquiLeader algo = new EquiLeader();

        final int nbOfEquiLeader = algo.solution(sourceArray);
        Assert.assertEquals(0, nbOfEquiLeader);
    }


}
