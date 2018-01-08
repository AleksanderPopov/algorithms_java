package algorithms.sorts;

import java.util.Arrays;

public class MergeSort {

    public static int[] perform(int[] source) {
        if (source.length == 1) return source;
        int[] farr = Arrays.copyOfRange(source, 0, source.length / 2);
        int[] sarr = Arrays.copyOfRange(source, source.length / 2, source.length);
        return merge(perform(farr), perform(sarr));
    }

    private static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        for (int i = 0, firstIndex = 0, secondIndex = 0; i < result.length; i++) {

            if (firstIndex != first.length && secondIndex != second.length) {
                result[i] = first[firstIndex] < second[secondIndex] ? first[firstIndex++] : second[secondIndex++];
                continue;
            }

            if (firstIndex == first.length)
                System.arraycopy(second, secondIndex, result, i, second.length - secondIndex);
            if (secondIndex == second.length)
                System.arraycopy(first, firstIndex, result, i, first.length - firstIndex);
            break;
        }
        return result;
    }

}
