package eu.daxiongmao.codility.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CyclicRotationTest {

    private CyclicRotation cyclicRotationService = new CyclicRotation();

    @Test
    @DisplayName("Cyclic rotations")
    public void doRotation() {
        int[] given = { 3, 8, 9, 7, 6 };
        int[] expectations = {9, 7, 6, 3, 8};
        compareArrays(expectations, cyclicRotationService.doCyclicRotation(given, 3));

        given = new int[] { 1, 2 };
        expectations = new int[] { 2, 1 };
        compareArrays(expectations, cyclicRotationService.doCyclicRotation(given, 1));

        given = new int[] { 1 };
        expectations = new int[] { 1 };
        compareArrays(expectations, cyclicRotationService.doCyclicRotation(given, 5));

        given = new int[] { 0,0,0 };
        expectations = new int[] { 0,0,0 };
        compareArrays(expectations, cyclicRotationService.doCyclicRotation(given, 1));

        given = new int[] { 1,2,3,4 };
        expectations = new int[] { 1,2,3,4 };
        compareArrays(expectations, cyclicRotationService.doCyclicRotation(given, 4));

        given = new int[] { 9,9,9,9 };
        expectations = new int[] { 9,9,9,9 };
        compareArrays(expectations, cyclicRotationService.doCyclicRotation(given, 4));


    }

    private void compareArrays(int[] expectation, int[] result) {
        Assertions.assertNotNull(expectation);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectation.length, result.length, "Arrays should have the same size");
        for (int i = 0 ; i < expectation.length ; i++) {
            Assertions.assertEquals(expectation[i], result[i], String.format("expectation[%d]:%s != result[%d]:%s", i, expectation[i], i, result[i]));
        }
    }

}
