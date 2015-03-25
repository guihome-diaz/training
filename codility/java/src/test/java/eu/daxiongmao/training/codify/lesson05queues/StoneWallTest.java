package eu.daxiongmao.training.codify.lesson05queues;

import org.junit.Assert;
import org.junit.Test;

public class StoneWallTest {

    @Test
    public void exampleDataTest() {
        final int[] wallHeights = new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8};

        final StoneWall algo = new StoneWall();
        final int nbOfSquares = algo.countRectangles(wallHeights);

        Assert.assertEquals(7, nbOfSquares);
    }

    @Test
    public void customSkyLine() {
        final int[] wallHeights = new int[] {5, 14, 13, 13, 11, 3, 3, 4, 8, 5, 18, 18, 14, 10, 11, 15, 5, 4, 3, 3, 6, 7, 14, 14};

        final StoneWall algo = new StoneWall();
        final int nbOfSquares = algo.countRectangles(wallHeights);

        Assert.assertEquals(16, nbOfSquares);
    }

}
