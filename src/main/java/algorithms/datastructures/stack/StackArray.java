package algorithms.datastructures.stack;

import java.util.Arrays;

public class StackArray<T> implements Stack<T> {
    private Object[] data = new Object[10];
    private int pointer = data.length - 1;

    public void push(T item) {
        if (pointer == 0) {
            this.grow();
        }
        data[pointer--] = item;
    }

    public T pop() {
        try {
            return this.peek();
        } finally {
            data[pointer++] = null;
        }
    }

    public T peek() {
        return (T) data[pointer + 1];
    }

    private void grow() {
        Object[] newData = new Object[data.length * 2];
        this.pointer = pointer + data.length;
        System.arraycopy(data, 0, newData, newData.length - data.length, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder = builder.append("[");
        for (int i = this.pointer + 1; i < this.data.length; i++) {
            builder = builder.append(this.data[i].toString()).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder = builder.append("]");
        return builder.toString();
    }

}
