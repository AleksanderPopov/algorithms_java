package algorithms.sorts;

import java.util.Arrays;

public class QuickSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result, 0, result.length);
        return result;
    }

    private static void sort(int[] source, int start, int end) {
        if (end - start < 2) return;

        int pivotIndex = start;
        int pivot = source[pivotIndex];

        int i = start;
        int j = end;


        while (i < j) {
            while (i < j && source[--j] >= pivot);
            if (source[j] < pivot) source[i] = source[j];

            while (i < j && source[++i] <= pivot);
            if (source[i] > pivot) source[j] = source[i];
        }
        source[i] = pivot;


        sort(source, start, i);
        sort(source, i + 1, end);
    }
}
