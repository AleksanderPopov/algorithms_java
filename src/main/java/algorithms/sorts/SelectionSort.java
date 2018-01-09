package algorithms.sorts;

import java.util.Arrays;

public class SelectionSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result);
        return result;
    }

    private static void sort(int[] source) {
        for (int unsortedPartitionIndex = source.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            int tmp = 0;
            for (int i = 0; i <= unsortedPartitionIndex; i++) {
                if (source[i] > source[tmp]) {
                    tmp = i;
                }
            }
            swap(source, tmp, unsortedPartitionIndex);
        }
    }

    private static void swap(int[] arr, int findex, int sindex) {
        int tmp = arr[findex];
        arr[findex] = arr[sindex];
        arr[sindex] = tmp;
    }

}
