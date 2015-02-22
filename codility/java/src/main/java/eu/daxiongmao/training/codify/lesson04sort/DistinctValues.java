package eu.daxiongmao.training.codify.lesson04sort;

import eu.daxiongmao.training.codify.utils.MergeSort;

/**
 * To extract the distinct values within a given array using a merge sort.
 *
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class DistinctValues {

    public int solutionUsingPersonalMergeSort(Integer[] arrayToProcess) {
        Integer[] sortedArray = MergeSort.mergeSort(arrayToProcess);

        // Go over the array and count the number of distinct values
        int currentValue = 0;
        int nbOfDifferentValues = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] > currentValue) {
                currentValue = sortedArray[i];
                nbOfDifferentValues++;
            }
        }

        return nbOfDifferentValues;
    }

}
