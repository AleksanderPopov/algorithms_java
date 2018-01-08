package algorithms.sorts;

import java.util.Arrays;

public class BubbleSort {
    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        for (int unsortedPartition = result.length - 1; unsortedPartition > 0; unsortedPartition--) {
            for (int i = 0; i < unsortedPartition; i++) {
                if (result[i] > result[i + 1]) {
                    swap(result, i, i + 1);
                    ;
                }
            }
        }
        return result;
    }

    private static void swap(int[] arr, int findex, int sindex) {
        int tmp = arr[findex];
        arr[findex] = arr[sindex];
        arr[sindex] = tmp;
    }
}
