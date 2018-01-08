package algorithms.sorts;

import java.util.Arrays;

public class SelectionSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        for (int unsortedPartitionIndex = result.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            int tmp = 0;
            for (int i = 0; i <= unsortedPartitionIndex; i++) {
                if (result[i] > result[tmp]) {
                    tmp = i;
                }
            }
            swap(result, tmp, unsortedPartitionIndex);
        }
        return result;
    }

    private static void swap(int[] arr, int findex, int sindex) {
        int tmp = arr[findex];
        arr[findex] = arr[sindex];
        arr[sindex] = tmp;
    }

}
