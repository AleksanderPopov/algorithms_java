package algorithms.sorts;

import java.util.Arrays;

public class RadixSort {
    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);

        int width = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i *= 10) {
            if (((int) (source[0] / i)) > 0) width = i;
            else break;
        }

        for (; width > 0; width = (int) (width / 10)) {
            int[] howToSortArray = new int[result.length];
            for (int i = 0; i < howToSortArray.length; i++) {
                howToSortArray[i] = (int) (result[i] / width);
            }
            // sort

        }

        return result;
    }
}
