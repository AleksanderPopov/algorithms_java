package algorithms.datastructures;

import algorithms.datastructures.list.List;
import algorithms.datastructures.list.SingleLinkedList;

import static org.junit.Assert.assertEquals;

public class SingleLinkedListTest {
    @org.junit.Test
    public void test0() {
        List<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add("a");
        singleLinkedList.add("b");
        singleLinkedList.add("c");
        singleLinkedList.add("d");

        assertEquals("a", singleLinkedList.get(0));
        assertEquals("b", singleLinkedList.get(1));
        assertEquals("c", singleLinkedList.get(2));
        assertEquals("d", singleLinkedList.get(3));

        assertEquals(true, singleLinkedList.contains("b"));

        assertEquals("c", singleLinkedList.set(2, "z"));

        assertEquals(4, singleLinkedList.size());

        singleLinkedList.remove(1);
        assertEquals("a", singleLinkedList.get(0));
        assertEquals("z", singleLinkedList.get(1));
        assertEquals("d", singleLinkedList.get(2));
    }
}
