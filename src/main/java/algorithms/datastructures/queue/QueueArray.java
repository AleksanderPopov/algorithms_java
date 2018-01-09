package algorithms.datastructures.queue;

public class QueueArray<T> implements Queue<T> {
    private Object[] data = new Object[10];
    private int startPointer = 0;
    private int endPointer = 0;

    @Override
    public void add(T item) {
        if (endPointer == data.length - 1) {
            if (startPointer == 0) {
                this.grow();
            } else {
                this.moveDataToBeginning();
            }
        }
        this.data[endPointer++] = item;
    }

    @Override
    public T remove() {
        try {
            return (T) data[startPointer];
        } finally {
            data[startPointer++] = null;
        }
    }

    @Override
    public T peek() {
        return (T) data[startPointer];
    }

    private void grow() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private void moveDataToBeginning() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, startPointer, newData, 0, data.length - startPointer);
        data = newData;
    }

}
