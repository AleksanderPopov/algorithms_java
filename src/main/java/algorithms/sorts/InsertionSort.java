package algorithms.sorts;

import java.util.Arrays;

public class InsertionSort {

    public static int[] performRecursive(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sortRecursive(result, 1);
        return result;
    }

    private static void sortRecursive(int[] source, int currentUnsortedIndex) {
        if (currentUnsortedIndex == source.length) return;;

        int currentUnsorted = source[currentUnsortedIndex];

        int i;

        for (i = currentUnsortedIndex; i > 0 && currentUnsorted < source[i - 1]; i--) {
            source[i] = source[i - 1];
        }

        source[i] = currentUnsorted;

        sortRecursive(source, currentUnsortedIndex + 1);
    }

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result);
        return result;
    }

    private static void sort(int[] source) {
        for (int currentUnsortedIndex = 1; currentUnsortedIndex < source.length; currentUnsortedIndex++) {
            int currentUnsorted = source[currentUnsortedIndex];

            int i;

            for (i = currentUnsortedIndex; i > 0 && currentUnsorted < source[i - 1]; i--) {
                source[i] = source[i - 1];
            }
            source[i] = currentUnsorted;
        }
    }

}
