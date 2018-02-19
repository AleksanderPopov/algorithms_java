package algorithms;

import org.junit.Test;
import java.util.Arrays;

import static algorithms.Subsets.getSubsets;

public class SubsetsTest {
    @Test
    public void test() {
        System.out.println(Arrays.toString(new int[]{}) + " - " + Arrays.deepToString(getSubsets(new int[]{})));
        System.out.println(Arrays.toString(new int[]{1}) + " - " + Arrays.deepToString(getSubsets(new int[]{1})));
        System.out.println(Arrays.toString(new int[]{1, 2}) + " - " + Arrays.deepToString(getSubsets(new int[]{1, 2})));
        System.out.println(Arrays.toString(new int[]{1, 2, 3}) + " - " + Arrays.deepToString(getSubsets(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4}) + " - " + Arrays.deepToString(getSubsets(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5}) + " - " + Arrays.deepToString(getSubsets(new int[]{1, 2, 3, 4, 5})));
    }

}
