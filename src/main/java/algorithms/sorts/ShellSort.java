package algorithms.sorts;

import java.util.Arrays;

public class ShellSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result);
        return result;
    }

    private static void sort(int[] source) {
        for (int gap = source.length / 2; gap > 0; gap /= 2) { // gap count
            for (int i = gap; i < source.length; i++) {
                int tmp = source[i]; // closer to end value
                int j;
                for (j = i; j >= gap && source[j - gap] > tmp; j -= gap) {
                    source[j] = source[j - gap];
                }
                source[j] = tmp;
            }
        }
    }

}
