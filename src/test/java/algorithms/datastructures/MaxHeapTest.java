package algorithms.datastructures;

import algorithms.datastructures.heaps.MaxHeap;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class MaxHeapTest {
    @Test
    public void test() {
        List<Integer> a = new Random().ints(0, 20).limit(15).boxed().collect(toList());
        Collections.shuffle(a);
        Integer integer = a.stream().max(Integer::compareTo).get();

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        a.forEach(maxHeap::insert);
        System.out.println(maxHeap.peek());
        maxHeap.remove(integer);
        System.out.println(maxHeap.peek());
    }
}
