package eu.daxiongmao.training.codify.lesson04sort;

import eu.daxiongmao.training.codify.utils.MergeSort;
import java.util.Collections;
import java.util.List;

/**
 * To compute the "max product of three" algorithm.
 *
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class MaxProductOfThree {

    public int solutionUsingPersonalMergeSort(final Integer[] arrayToProcess) {
        return computeMaxProductOfThree(MergeSort.mergeSort(arrayToProcess));
    }

    public int solutionUsingJavaSort(final List<Integer> listToProcess) {
        Collections.sort(listToProcess);
        return computeMaxProductOfThree((Integer[]) listToProcess.toArray());
    }

    private Integer computeMaxProductOfThree(final Integer[] sortedArray) {
        // an array can contains big positive and negative values.
        Integer positiveProduct = sortedArray[sortedArray.length - 1] * sortedArray[sortedArray.length - 2] * sortedArray[sortedArray.length - 3];

        // Only a double negative value will be useful!
        if (sortedArray[1] >= 0) {
            return  positiveProduct;
        }

        // Compare 2 possibilities
        int negativeProduct = Math.abs(sortedArray[0] * sortedArray[1] * sortedArray[sortedArray.length - 1]);
        if (negativeProduct > positiveProduct) {
            return negativeProduct;
        } else {
            return positiveProduct;
        }
    }
}
