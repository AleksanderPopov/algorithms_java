package algorithms.search;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    @Test
    public void test() {
        List<Integer> a = new Random().ints(1000, 10_000).limit(10).boxed().collect(toList());

        Collections.shuffle(a);
        Integer[] array = a.toArray(new Integer[] {});

        assertEquals(5, BinarySearch.perform(array, array[5]));
    }
}
