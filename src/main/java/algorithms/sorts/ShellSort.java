package algorithms.sorts;

import java.util.Arrays;

public class ShellSort {
    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);

        for (int gap = result.length / 2; gap > 0; gap /= 2) { // gap count
            for (int i = gap; i < result.length; i++) {
                int tmp = result[i]; // closer to end value
                int j;
                for (j = i; j >= gap && result[j - gap] > tmp; j -= gap) {
                    result[j] = result[j - gap];
                }
                result[j] = tmp;
            }
        }

        return result;
    }
}
