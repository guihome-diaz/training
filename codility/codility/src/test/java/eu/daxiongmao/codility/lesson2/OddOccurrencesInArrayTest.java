package eu.daxiongmao.codility.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OddOccurrencesInArrayTest {

    private OddOccurrencesInArray service = new OddOccurrencesInArray();

    @Test
    @DisplayName("Look for the mistigri")
    public void lookForTheMistigri() {
        Assertions.assertEquals(7, service.findOddOccurrence(new int[]{9,3,9,3,9,7,9}));
        Assertions.assertEquals(-5, service.findOddOccurrence(new int[]{-1,-1,-1,-1,-5}));
        Assertions.assertEquals(-5, service.findOddOccurrence(new int[]{-1,-1,-1}));
    }
}
