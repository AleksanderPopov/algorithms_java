package algorithms.sorts;

import java.util.Arrays;

public class CountingSort {

    public static int[] perform(int[] source, int min, int max) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result, min, max);
        return result;
    }

    private static void sort(int[] source, int min, int max) {
        int[] counting = new int[max - min + 1];

        for (int i = 0; i < source.length; i++) {
            counting[source[i] - min]++;
        }

        for (int i = 0, j = 0; i < counting.length; i++) {
            if (counting[i] > 0) {
                for (int k = 0; k < counting[i]; k++, j++) {
                    source[j] = i + min;
                }
            }
        }
    }

}
