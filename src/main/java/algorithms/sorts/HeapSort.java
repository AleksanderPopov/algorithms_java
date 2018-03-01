package algorithms.sorts;

import algorithms.datastructures.heaps.MaxHeap;

import java.util.Arrays;

public class HeapSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result);
        return result;
    }

    private static void sort(int[] source) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for(int i : source) maxHeap.insert(i);
        for (int i = source.length - 1; i >= 0; i--) {
            source[i] = maxHeap.remove();
        }
    }

}
