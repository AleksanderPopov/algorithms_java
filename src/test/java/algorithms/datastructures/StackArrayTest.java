package algorithms.datastructures;

import algorithms.datastructures.stack.StackArray;

import static org.junit.Assert.assertEquals;

public class StackArrayTest {
    @org.junit.Test
    public void test0() {
        StackArray<String> stackArray = new StackArray<>();
        stackArray.push("a");
        stackArray.push("b");
        stackArray.push("c");
        stackArray.push("d");
        stackArray.push("e");
        stackArray.push("f");
        stackArray.push("g");
        stackArray.push("h");
        stackArray.push("y");
        stackArray.push("z");
        stackArray.push("w");

        assertEquals("w", stackArray.peek());
        assertEquals("w", stackArray.pop());
        assertEquals("z", stackArray.pop());
        assertEquals("y", stackArray.pop());
        assertEquals("h", stackArray.pop());
        assertEquals("g", stackArray.pop());
        assertEquals("f", stackArray.pop());
        assertEquals("e", stackArray.pop());
        assertEquals("d", stackArray.pop());
        assertEquals("c", stackArray.pop());
        assertEquals("b", stackArray.pop());
        assertEquals("a", stackArray.pop());

    }
}
