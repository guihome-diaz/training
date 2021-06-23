package eu.daxiongmao.codility.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TapeEquilibriumTest {

    TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

    @Test
    public void getEquilibrium() {
        Assertions.assertEquals(1, tapeEquilibrium.computeTapeEquilibrium(new int[] {3,1,2,4,3}));
        Assertions.assertEquals(0, tapeEquilibrium.computeTapeEquilibrium(new int[] {1,1}));
        Assertions.assertEquals(1, tapeEquilibrium.computeTapeEquilibrium(new int[] {10,5,5,1,22}));
        Assertions.assertEquals(1, tapeEquilibrium.computeTapeEquilibrium(new int[] {-10,5,5,1,2}));
        Assertions.assertEquals(0, tapeEquilibrium.computeTapeEquilibrium(new int[] {-10,5,5,1,1}));
    }

}
