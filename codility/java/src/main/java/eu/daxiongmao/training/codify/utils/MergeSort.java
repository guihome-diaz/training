package eu.daxiongmao.training.codify.utils;

/**
 * Merge sort implementation.<br/>
 * The idea is to divide the unsorted array into 2 halves, sort each half separately and then just merge them.<br/>
 * This is based upon the wikipedia example: http://en.wikipedia.org/wiki/Merge_sort<br/>
 * <br/>
 * To get a better sort use Java Collections.sort(). <br/>
 * This example is just here for personal reference and performances comparison.
 */
public final class MergeSort {

    /** Private factory design pattern. It prevent instantiation of utility classes. */
    private MergeSort() { }

    /**
     * To sort an array in NATURAL order (from 0 to N) using a MERGE sort.<br/>
     * This sort function result in O(n.log(n)) complexity.
     */
    public static Integer[] mergeSort(final Integer[] arrayToSort) {
        // Argument check - avoid NullPointerException
        if (arrayToSort == null) {
            return new Integer[0];
        }
        // no element or a single one ==> nothing to do as it is already sorted by nature!
        if (arrayToSort.length <= 1) {
            return arrayToSort;
        }

        // ****** 1. DIVIDE the list ******
        final int middleSize = arrayToSort.length / 2;

        // If list size is not even, don't forget to add the missing element!
        Integer[] left = new Integer[middleSize];
        int rightSize = middleSize;
        if (arrayToSort.length % 2 != 0) {
            rightSize++;
        }
        Integer[] right = new Integer[rightSize];

        // Populate the list content
        for (int i = 0; i < middleSize; i++) {
            left[i] = arrayToSort[i];
        }
        int index = 0;
        for (int i = middleSize; i < arrayToSort.length; i++) {
            right[index] = arrayToSort[i];
            index++;
        }

        // ****** 2. Sort each side (recursive) *****
        // TODO: These calls should be isolated in a dedicated threads ==> fork()
        left = mergeSort(left);
        right = mergeSort(right);

        // ****** 3. Merge results *****
        // TODO: merge the threads ==> join()
        return merge(left, right);
    }


    /**
     * To merge values in NATURAL order. <br>
     *     This will order values from <strong>min to max</strong>.
     *     Therefore, left is always first because the index is sort from 0 to N
     *
     * @param left left array
     * @param right right array
     * @return the merge of both arrays in natural order (from 0 to N).
     */
    private static Integer[] merge(final Integer[] left, final Integer[] right) {
        final Integer[] result = new Integer[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        // Comparison of both arrays
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        // Processing remaining values
        while(leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }

}
