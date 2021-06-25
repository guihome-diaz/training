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

        final int[] sequence = new int[input.length];
        // Populate items list
        final List<ArrayItem> items = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            items.add(new ArrayItem(i, input[i]));
        }
        // Sort items list
        Collections.sort(items);

        int sum = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            final ArrayItem item = items.get(i);
            System.out.println(item);

            if (sum == 0) {
                // apply current value
                sum = item.value;
                sequence[item.index] = item.isNegative() ? -1 : 1;
                continue;
            }

            // Compute sequence and new sum
            int minDifferenceAbs = getMinDifferenceAbs(sum, item.absoluteValue);
            int sequenceValue = setSequence(sum, item, minDifferenceAbs, sequence);
            sum = sum + (item.value * sequenceValue);
        }

        // print sequence
        System.out.println("sequence S: " + Arrays.toString(sequence));
        return Math.abs(sum);
    }

    private int getMinDifferenceAbs(final int sum, final int itemValueAbs) {
        return Math.abs(Math.abs(sum) - itemValueAbs);
    }

    private int setSequence(final int sum, final ArrayItem item, final int minDifferenceAbs, final int[] sequence) {
        int sequenceValue = 0;
        if (Math.abs(sum + item.value) == minDifferenceAbs) {
            sequenceValue = 1;
        } else {
            sequenceValue = -1;
        }
        sequence[item.index] = sequenceValue;
        return sequenceValue;
    }

    class ArrayItem implements Serializable, Comparable {
        public final int index;
        public final int value;
        public final int absoluteValue;

        public ArrayItem(final int index, final int value) {
            this.index = index;
            this.value = value;
            this.absoluteValue = Math.abs(value);
        }

        public boolean isNegative() {
            return this.value < 0;
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
            return index == arrayItem.index && value == arrayItem.value && absoluteValue == arrayItem.absoluteValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, value, absoluteValue);
        }

        @Override
        public String toString() {
            return String.format("item[%s]=%s | abs: %s", index, value, absoluteValue);
        }
    }

}
