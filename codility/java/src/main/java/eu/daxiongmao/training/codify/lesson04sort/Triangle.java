package eu.daxiongmao.training.codify.lesson04sort;

import eu.daxiongmao.training.codify.utils.MergeSort;

/**
 * To check if the given array contains a triangle, according to the related "triangle" definition. <br/>
 * In that example we are only considering 1 dimension. <br/>
 * So it is 'hard' to represents it on paper, even though the reflexive process is quite easy. ^^
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class Triangle {

    /**
     * A zero-indexed array A consisting of N integers is given.<br/>
     * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
     * <ul>
     *     <li>A[P] + A[Q] > A[R]</li>
     *     <li>A[Q] + A[R] > A[P]</li>
     *     <li>A[R] + A[P] > A[Q]</li>
     * </ul>
     * @return boolean 0 == no triangle inside the given array || 1 == a triangle has been found!
     */
    public int solutionWithPersonalMerge(Integer[] arrayToProcess) {
        Integer[] sortedArray = MergeSort.mergeSort(arrayToProcess);

        // Compare values in order, 3 by 3.
        int result = 0;
        for (int i = 0; i < sortedArray.length - 2; i++) {
            if (sortedArray[i] + sortedArray[i+1] > sortedArray[i+2]
                    && sortedArray[i+1] + sortedArray[i+2] > sortedArray[i]
                    && sortedArray[i] + sortedArray[i+2] > sortedArray[i+1]) {
                result = 1;
                break;
            }
        }
        return result;
    }

}
