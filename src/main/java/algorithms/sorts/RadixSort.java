package algorithms.sorts;

import java.util.Arrays;

public class RadixSort {

    public static int[] perform(int[] source, int radix) {
        int width = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i *= 10) {
            if (((int) (source[0] / i)) > 0) width++;
            else break;
        }
        return perform(source, radix, width);
    }

    public static int[] perform(int[] source, int radix, int width) {
        int[] result = Arrays.copyOf(source, source.length);
        for (int i = 0; i < width; i++) {
            radixSingleSort(result, i, radix);
        }
        return result;
    }

    private static int[] radixSingleSort(int[] result, int position, int radix) {

        int numItems = result.length;
        int[] countArray = new int[radix];

        for (int value : result) {
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, result[tempIndex], radix)]] = result[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            result[tempIndex] = temp[tempIndex];
        }

        return result;
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    public static String[] performOnString(String[] source, char radix) {
        return performOnString(source, radix, source[0].length());
    }

    public static String[] performOnString(String[] source, char radix, int width) {
        String[] result = Arrays.copyOf(source, source.length);
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSortString(result, i, radix);
        }
        return result;
    }

    private static String[] radixSingleSortString(String[] result, int position, char radix) {

        int numItems = result.length;
        int[] countArray = new int[radix];

        for (String value : result) {
            countArray[getChar(position, value)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getChar(position, result[tempIndex])]] = result[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            result[tempIndex] = temp[tempIndex];
        }

        return result;
    }

    private static int getChar(int position, String value) {
        return value.charAt(position);
    }

}
