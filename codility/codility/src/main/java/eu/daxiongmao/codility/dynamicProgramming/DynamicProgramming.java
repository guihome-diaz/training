package eu.daxiongmao.codility.dynamicProgramming;

import java.util.*;

/**
 * Minimum result for val(A,S)
 * @author Guillaume
 * @version 2021/06
 */
public class DynamicProgramming {

    public int computeMinimumSum(int[] input) {
        if (input.length == 0) { return 0; }
        // Array should be odd size
        if (input.length % 2 != 0) {
            throw new IllegalArgumentException("Input array must be of even size");
        }

        // extract odd and even values
        // Default assumption is S[-1,1,-1,1,-1,1,..,-1,1]
        final int middleSize = input.length / 2;
        int sumOddNumbers = 0;
        int [] oddNumbers = new int[middleSize];
        int sumEvenNumbers = 0;
        int [] evenNumbers = new int[middleSize];
        boolean[] invertSequence = new boolean[middleSize];
        final Map<Integer, List<Integer>> differenceOddEven = new HashMap<>();

        int currentIndex = 0;
        for (int i = 0 ; i < input.length; i++) {
            if (i % 2 == 0) {
                // Even numbers
                evenNumbers[currentIndex] = input[i];
                sumEvenNumbers += input[i];
            } else {
                // Odd numbers
                oddNumbers[currentIndex] = input[i];
                sumOddNumbers += input[i];
                // Compute difference between odd / even
                final int difference = evenNumbers[currentIndex] - oddNumbers[currentIndex];
                if (differenceOddEven.containsKey(difference)) {
                    differenceOddEven.get(difference).add(currentIndex);
                } else {
                    final List<Integer> indexesToInvert = new ArrayList<>();
                    indexesToInvert.add(currentIndex);
                    differenceOddEven.put(difference, indexesToInvert);
                }
                // Move on the cursor
                currentIndex++;
            }
        }

        // Best case: odd and even numbers are equals. Do nothing: we keep the original sequence
        int difference = sumEvenNumbers - sumOddNumbers;
        if (difference == 0) {
            System.out.println("Result: S[-1,1,-1,1,-1,1,..,-1,1] # default sequence is the best one");
            return 0;
        }

        // Compute available differences
        final List<Integer> differencesValues = new ArrayList<>();
        for (int diff : differenceOddEven.keySet()) {
            differencesValues.add(diff);
        }
        Collections.sort(differencesValues);

        // Compute alternatives sequences
        int index = differencesValues.size() - 1;
        while (index != 0 && difference != 0) {
            // Find the next suitable value
            while (index > 0 && differencesValues.get(index) > difference) {
                index--;
            }
            if (index != 0) {
                // retrieve index to invert in the sequence S {-1,1}
                int diff = differencesValues.get(index);
                int indexToInvert = differenceOddEven.get(diff).get(0);
                // cleanup map
                differenceOddEven.get(diff).remove(indexToInvert);
                if (differenceOddEven.get(diff).isEmpty()) {
                    differenceOddEven.remove(diff);
                }
                // Apply changes
                invertSequence[indexToInvert] = true;
                difference = difference - diff;
            }
        }

        // build sequence and result
        int result = 0;
        final StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < invertSequence.length; i++) {
            if (invertSequence[i]) {
                result += (evenNumbers[i] - oddNumbers[i]);
                sequence.append("1,-1");
            } else {
                result += (-evenNumbers[i] + oddNumbers[i]);
                sequence.append("-1,1");
            }
        }
        System.out.println("Result: S[" + sequence.toString() + "]");


        // smallest difference is the rest
        return difference;
    }


}
