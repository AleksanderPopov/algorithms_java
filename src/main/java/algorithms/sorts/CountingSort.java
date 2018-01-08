package algorithms.sorts;

import java.util.Arrays;

public class CountingSort {

    public static int[] perform(int[] source, int min, int max) { // from 1 to 10
        int[] result = Arrays.copyOf(source, source.length);
        int[] counting = new int[max - min + 1];

        for (int i = 0; i < result.length; i++) {
            counting[result[i] - min]++;
        }

        for (int i = 0, j = 0; i < counting.length; i++) {
            if (counting[i] > 0) {
                for (int k = 0; k < counting[i]; k++, j++) {
                    result[j] = i + min;
                }
            }
        }

        return result;
    }

}
