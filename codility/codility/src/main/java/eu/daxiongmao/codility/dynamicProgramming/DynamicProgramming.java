package eu.daxiongmao.codility.dynamicProgramming;

import java.io.Serializable;
import java.util.*;

/**
 * Minimum result for val(A,S)
 * @author Guillaume
 * @version 2021/06
 */
public class DynamicProgramming {

    public int computeMinimumSum(int[] input) {
        if (input.length == 0) { return 0; }
        if (input.length == 1) { return Math.abs(input[0]);}

        System.out.println(String.format("%n*********** Given ***********"));
        System.out.println(Arrays.toString(input));

        //******************************************************
        // Step 1. Extract data for later processing
        //******************************************************
        System.out.println(" ... Extract data");
        // items: each entry represents input[i]
        final List<ArrayItem> items = new ArrayList<>();
        // flag to know if the array is composed of 1 single value
        boolean alwaysTheSameValue = true;
        int originalValue = Math.abs(input[0]);

        for (int i = 0; i < input.length; i++) {
            final int absValue = Math.abs(input[i]);
            // extract item
            ArrayItem item = new ArrayItem(input[i], absValue);
            items.add(item);
            // Array composition check
            if (alwaysTheSameValue && originalValue != absValue) {
                alwaysTheSameValue = false;
            }
        }

        //******************************************************
        // Step 2. Basic processing: is the array composed of a single value?
        //******************************************************
        if (alwaysTheSameValue) {
            System.out.println(" ... Input is a repetition of a single number");
            if (input.length % 2 == 0) {
                // Even size: min result is always zero. We just have to find the right sequence
                return 0;
            } else {
                // One element remain. It's absolute value is the result
                return Math.abs(input[0]);
            }
        }

        //******************************************************
        // Step 3. Compute min sum based on items values
        //******************************************************
        System.out.println(" ... Processing [natural items]");
        // Compute permutations
        int originalSum = computePermutations(items);
        if (originalSum == 0) { return 0; }


        //******************************************************
        // Step 4. Compute min sum based on grouped values (for instance: sum all '3' or '2' and use global value)
        //******************************************************
        System.out.println(" ... Processing [grouped items by vabs]");
        // Regroup items by absolute values
        int currentVabs = 0;
        int currentCount = 0;
        final List<ArrayItem> groupItems = new ArrayList<>();
        for (int i = items.size() - 1; i >= 0; i--) {
            final ArrayItem item = items.get(i);
            if (currentVabs == item.absoluteValue) {
                currentCount++;
            } else {
                if (currentCount != 0) {
                    groupItems.add(new ArrayItem(currentVabs * currentCount));
                }
                currentVabs = item.absoluteValue;
                currentCount = 1;
            }
        }
        if (currentCount != 0 && currentVabs != 0) {
            groupItems.add(new ArrayItem(currentVabs * currentCount));
        }
        // Compute permutations
        int groupedSum = computePermutations(groupItems);

        return (originalSum <= groupedSum ? originalSum : groupedSum);
    }

    private int computePermutations(final List<ArrayItem> items) {
        // sort input
        Collections.sort(items);

        int sum = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            final ArrayItem item = items.get(i);
            if (sum == 0) {
                // apply current value
                sum = item.value;
                //System.out.println(String.format("Iteration %3d # %s # sum=%5d",i, item, sum));
                continue;
            }

            // Compute sequence and new sum
            int minDifferenceAbs = getMinDifferenceAbs(sum, item.absoluteValue);
            int sequenceValue = setSequence(sum, item, minDifferenceAbs);
            sum = sum + (item.value * sequenceValue);
            //System.out.println(String.format("Iteration %3d # %s # sum=%5d",i, item, sum));
        }

        // print sequence
        System.out.println(" ... Sum=" + sum);
        return Math.abs(sum);
    }

    private int getMinDifferenceAbs(final int sum, final int itemValueAbs) {
        return Math.abs(Math.abs(sum) - itemValueAbs);
    }

    private int setSequence(final int sum, final ArrayItem item, final int minDifferenceAbs) {
        int sequenceValue = 0;
        if (Math.abs(sum + item.value) == minDifferenceAbs) {
            sequenceValue = 1;
        } else {
            sequenceValue = -1;
        }
        return sequenceValue;
    }

    class ArrayItem implements Serializable, Comparable {
        public final int value;
        public final int absoluteValue;

        public ArrayItem(final int absoluteValue) {
            this.absoluteValue = absoluteValue;
            this.value = absoluteValue;
        }

        public ArrayItem(final int value, final int absoluteValue) {
            this.value = value;
            this.absoluteValue = absoluteValue;
        }

        @Override
        public int compareTo(Object other) {
            if (!(other instanceof ArrayItem)) {
                return 1;
            }
            return Integer.compare(this.absoluteValue, ((ArrayItem) other).absoluteValue);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false;}
            ArrayItem arrayItem = (ArrayItem) o;
            return value == arrayItem.value && absoluteValue == arrayItem.absoluteValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, absoluteValue);
        }

    }

}
