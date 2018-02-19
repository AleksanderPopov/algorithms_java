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

        int s = start;
        int e = end;


        while (s < e) {
            while (s < e && source[--e] >= pivot);
            if (source[e] < pivot) source[s] = source[e];

            while (s < e && source[++s] <= pivot);
            if (source[s] > pivot) source[e] = source[s];
        }
        source[s] = pivot;


        sort(source, start, s);
        sort(source, s + 1, end);
    }
}
