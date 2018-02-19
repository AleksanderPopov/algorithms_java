package algorithms;

import java.util.Arrays;

public class Subsets {

    public static int[][] getSubsets(int[] set) {
        if (set.length == 0) return new int[][]{{}};
        else {
            int item = set[0];
            int[][] itemArr = toArr(item);
            int[][] subsets = getSubsets(subarrayFrom(1, set));
            int[][] multiplied = multiply(item, subsets);
            return multiplied != null ? concat(itemArr, subsets, multiplied) : concat(itemArr, subsets);
        }
    }

    private static int[][] multiply(int item, int[][] arr) {
        if (arr[0].length == 0) return null;
        int[][] result = new int[arr.length - 1][];
        for (int ri = 0, ai = 0; ri < result.length; ai++) {
            if (arr[ai].length == 0) {
                continue;
            }
            result[ri++] = concat(item, arr[ai]);
        }
        return result;
    }

    private static int[] concat(int item, int[] arr) {
        int[] result = new int[arr.length + 1];
        result[0] = item;
        System.arraycopy(arr, 0, result, 1, arr.length);
        return result;
    }

    private static int[] subarrayFrom(int index, int[] source) {
        if (index >= source.length) return new int[] {};
        int[] result = new int[source.length - index];
        System.arraycopy(source, index, result, 0, result.length);
        return result;
    }

    private static int[][] toArr(int item) {
        return new int[][]{{item}};
    }

    private static int[][] concat(int[][]... arrays) {
        int totalLength = 0;
        for (int[][] array : arrays) totalLength += array.length;

        int[][] result = new int[totalLength][];
        int pointer = 0;

        for (int[][] twoDimensionArray : arrays)
            for (int[] oneDimensionArray : twoDimensionArray)
                result[pointer++] = oneDimensionArray;

        return result;
    }

}
