package algorithms.sorts;

import java.util.Arrays;

public class BubbleSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result);
        return result;
    }

    private static void sort(int[] source) {
        for (int unsortedPartition = source.length - 1; unsortedPartition > 0; unsortedPartition--) {
            for (int i = 0; i < unsortedPartition; i++) {
                if (source[i] > source[i + 1]) {
                    swap(source, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int findex, int sindex) {
        int tmp = arr[findex];
        arr[findex] = arr[sindex];
        arr[sindex] = tmp;
    }
}
