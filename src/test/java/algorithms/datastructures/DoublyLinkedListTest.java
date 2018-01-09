package algorithms.datastructures;

import algorithms.datastructures.list.DoublyLinkedList;
import algorithms.datastructures.list.List;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {
    @org.junit.Test
    public void test0() {
        List<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add("a");
        doublyLinkedList.add("b");
        doublyLinkedList.add("c");
        doublyLinkedList.add("d");

        assertEquals("a", doublyLinkedList.get(0));
        assertEquals("b", doublyLinkedList.get(1));
        assertEquals("c", doublyLinkedList.get(2));
        assertEquals("d", doublyLinkedList.get(3));

        assertEquals(true, doublyLinkedList.contains("b"));

        assertEquals("c", doublyLinkedList.set(2, "z"));

        assertEquals(4, doublyLinkedList.size());

        doublyLinkedList.remove(1);
        assertEquals("a", doublyLinkedList.get(0));
        assertEquals("z", doublyLinkedList.get(1));
        assertEquals("d", doublyLinkedList.get(2));
    }
}
