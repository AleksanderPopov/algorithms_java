package algorithms.datastructures;

import algorithms.datastructures.queue.Queue;
import algorithms.datastructures.queue.QueueArray;
import algorithms.datastructures.stack.StackArray;

import static org.junit.Assert.assertEquals;

public class QueueArrayTest {
    @org.junit.Test
    public void test0() {
        Queue<String> queueArray = new QueueArray<>();
        queueArray.add("a");
        queueArray.add("b");
        queueArray.add("c");
        queueArray.add("d");
        queueArray.add("e");
        queueArray.add("f");
        queueArray.add("g");
        queueArray.add("h");
        queueArray.add("y");
        queueArray.add("z");
        queueArray.add("w");

        assertEquals("a", queueArray.peek());
        assertEquals("a", queueArray.remove());
        assertEquals("b", queueArray.remove());
        assertEquals("c", queueArray.remove());
        assertEquals("d", queueArray.remove());
        assertEquals("e", queueArray.remove());
        assertEquals("f", queueArray.remove());
        assertEquals("g", queueArray.remove());
        assertEquals("h", queueArray.remove());
        assertEquals("y", queueArray.remove());
        assertEquals("z", queueArray.remove());
        assertEquals("w", queueArray.remove());

    }
}
