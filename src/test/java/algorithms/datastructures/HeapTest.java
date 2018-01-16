package algorithms.datastructures;

import algorithms.datastructures.heaps.Heap;
import algorithms.datastructures.trees.BinaryTree;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class HeapTest {
    @Test
    public void test() {
        List<Integer> a = new Random().ints(0, 20).limit(15).boxed().collect(toList());
        Collections.shuffle(a);
        Integer integer = a.stream().max(Integer::compareTo).get();

        Heap<Integer> heap = new Heap<>();
        a.forEach(heap::insert);
        System.out.println(heap.peek());
        heap.remove(integer);
        System.out.println(heap.peek());
    }
}
