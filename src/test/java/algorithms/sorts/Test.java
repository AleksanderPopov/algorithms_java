package algorithms.sorts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Test {
    @org.junit.Test
    public void test() {
        List<Integer> a = new Random().ints(1000, 10_000).limit(10).boxed().collect(toList());

        Collections.shuffle(a);
        int[] array = a.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(a + " initial");
        int[] sorted = IntStream.of(array).sorted().toArray();

        int[] bubbleSorted = BubbleSort.perform(array);
        print(bubbleSorted, "bubble", sorted);

        int[] selectionSorted = SelectionSort.perform(array);
        print(selectionSorted, "selection", sorted);

        int[] insertionSorted = InsertionSort.perform(array);
        print(insertionSorted, "insertion", sorted);

        int[] insertionRecursiveSorted = InsertionSort.performRecursive(array);
        print(insertionRecursiveSorted, "insertion recursive", sorted);

        int[] shellSorted = ShellSort.perform(array);
        print(shellSorted, "shell", sorted);

        int[] mergeSorted = MergeSort.perform(array);
        print(mergeSorted, "merge", sorted);

        int[] countSorted = CountingSort.perform(array, 1000, 9999);
        print(countSorted, "count", sorted);

        int[] radixSorted = RadixSort.perform(array, 10_000);
        print(radixSorted, "radix", sorted);

        String[] radixStringSorted = RadixSort.performOnString(new String[] {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"}, 'z');
        printObj(radixStringSorted, "radix string", new String[] {"abcde", "bbbbb", "bcdef", "dbaqc", "omadd"});

        int[] heapSorted = HeapSort.perform(array);
        print(heapSorted, "heap", sorted);

        int[] quickSorted = QuickSort.perform(array);
        print(quickSorted, "quick", sorted);
    }

    private void print(int[] array, String name, int[] sorted) {
        System.out.println(String.format(
                "%s sort %s %s",
                Arrays.toString(array),
                name,
                Arrays.equals(array, sorted)
        ));
    }

    private void printObj(Object[] array, String name, Object[] sorted) {
        System.out.println(String.format(
                "%s sort %s %s",
                Arrays.toString(array),
                name,
                Arrays.equals(array, sorted)
        ));
    }

}
