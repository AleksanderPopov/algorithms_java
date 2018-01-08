package algorithms.sorts;

public class QuickSort {

    public static void perform(int[] source) {
        perform(source, 0, source.length);
    }

    private static void perform(int[] source, int start, int end) {
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


        perform(source, start, i);
        perform(source, i + 1, end);
    }
}
