package eu.daxiongmao.codility.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PermMissingElemTest {

    private PermMissingElem permMissingElem = new PermMissingElem();

    @Test
    @DisplayName("find missing element")
    public void findMissingElement() {
        Assertions.assertEquals(4, permMissingElem.getMissingElement(new int[] {2, 3, 1, 5}));
        Assertions.assertEquals(5, permMissingElem.getMissingElement(new int[] {1,2,3,4,6,7,8,9}));
        Assertions.assertEquals(1, permMissingElem.getMissingElement(new int[] {2,3,4,5,6,7,8,9}));
        Assertions.assertEquals(9, permMissingElem.getMissingElement(new int[] {1, 2,3,4,5,6,7,8}));
        Assertions.assertEquals(2, permMissingElem.getMissingElement(new int[] {1}));
        Assertions.assertEquals(1, permMissingElem.getMissingElement(new int[] {}));
    }
}
