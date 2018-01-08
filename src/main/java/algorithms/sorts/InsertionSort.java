package algorithms.sorts;

import java.util.Arrays;

public class InsertionSort {
    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);

        for (int currentUnsortedIndex = 1; currentUnsortedIndex < result.length; currentUnsortedIndex++) {
            int currentUnsorted = result[currentUnsortedIndex];

            for (int currentSortedIndex = currentUnsortedIndex - 1; currentSortedIndex >= 0; currentSortedIndex--) {
                if (currentUnsorted >= result[currentSortedIndex]) {
                    shiftLeft(result, currentUnsortedIndex + 1);
                    shiftRight(result, currentSortedIndex + 1);
                    result[currentSortedIndex + 1] = currentUnsorted;
                    break;
                } else if (currentSortedIndex == 0) {
                    shiftLeft(result, currentUnsortedIndex + 1);
                    shiftRight(result, currentSortedIndex);
                    result[currentSortedIndex] = currentUnsorted;
                    break;
                }
            }
        }

        return result;
    }

    private static void shiftLeft(int[] source, int from) {
        for (; from < source.length; from++) {
            if (from - 1 >= 0) {
                source[from - 1] = source[from];
            }
        }
    }

    private static void shiftRight(int[] source, int from) {
        for (int i = source.length - 1; from <= i && i > 0; i--) {
            source[i] = source[i - 1];
        }
    }

}
