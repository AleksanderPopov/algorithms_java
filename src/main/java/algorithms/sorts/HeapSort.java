package algorithms.sorts;

import algorithms.datastructures.heaps.Heap;

import java.util.Arrays;

public class HeapSort {

    public static int[] perform(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);
        sort(result);
        return result;
    }

    private static void sort(int[] source) {
        Heap<Integer> heap = new Heap<>();
        for(int i : source) heap.insert(i);
        for (int i = source.length - 1; i >= 0; i--) {
            source[i] = heap.remove();
        }
    }

}
