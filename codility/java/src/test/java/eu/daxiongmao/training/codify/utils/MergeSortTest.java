package eu.daxiongmao.training.codify.utils;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortTestBasic() {
        final Integer[] unorderedArray = new Integer[] {5, 2, 8, 14, -1, 1, 16, 4, -9, 1};
        final Integer[] orderedArray = MergeSort.mergeSort(unorderedArray);
        final Integer[] expectedResult = new Integer[] {-9, -1, 1, 1, 2, 4, 5, 8, 14, 16};

        Assert.assertEquals(expectedResult.length, orderedArray.length);
        for (int i = 0; i < expectedResult.length; i++) {
            String log = String.format("index %s | Expected result: %s | given result: %s", i, expectedResult[i], orderedArray[i]);
            System.out.println(log);
            Assert.assertEquals(expectedResult[i], orderedArray[i]);
        }
    }


    @Test
    public void sortTestBasic2() {
        final Integer[] unorderedArray = new Integer[] {5, 2, 0, 98, -256, 8, 14, -1, 1, 16, 4, -9, 1};
        final Integer[] orderedArray = MergeSort.mergeSort(unorderedArray);
        final Integer[] expectedResult = new Integer[] {-256, -9, -1, 0, 1, 1, 2, 4, 5, 8, 14, 16, 98};

        Assert.assertEquals(expectedResult.length, orderedArray.length);
        Assert.assertArrayEquals(expectedResult, orderedArray);
    }


}
