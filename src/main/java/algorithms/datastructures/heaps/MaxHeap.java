package algorithms.datastructures.heaps;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Heap<V extends Comparable<? super V>> {
    private Entry<V>[] data;
    private int pointer = 0;

    public Heap() {
        data = new Entry[10];
    }

    public V peek() {
        return data[0].value;
    }

    public void insert(V value) {
        if (this.contains(value)) return;
        data[pointer++] = new Entry<>(value);
        if (pointer >= this.data.length) {
            this.grow();
        }
        int parentIndex = this.getParent(pointer - 1);
        if (parentIndex >= 0 && this.data[parentIndex].value.compareTo(value) < 0) {
            this.heapify(pointer - 1);
        }
    }

    public V remove() {
        return this.remove(this.peek());
    }

    public V remove(V value) {
        if (!this.contains(value)) return null;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) break;
            if (this.data[i].value.equals(value)) {
                if (i + 1 >= this.data.length || this.data[i + 1] == null) {
                    V tmp = this.data[i].value;
                    this.data[i] = null;
                    pointer--;
                    return tmp;
                }
                V tmp = this.data[i].value;
                this.data[i] = this.data[pointer - 1];
                this.data[pointer - 1] = null;
                pointer--;
                this.heapify(i);
                return tmp;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) break;
            if (this.data[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.data[0] == null;
    }

    private void heapify(int index) {
        if (index < 0 || index >= this.data.length) return;
        int currentIndex = index;

        int parentIndex = this.getParent(index);
        boolean haveParent = parentIndex != -1;

        int biggestChildIndex = this.getBiggestChildIndex(currentIndex);
        boolean haveChild = biggestChildIndex != -1;

        if (haveParent && this.data[currentIndex].value.compareTo(this.data[parentIndex].value) > 0) {
            while (parentIndex >= 0 && this.data[currentIndex].value.compareTo(this.data[parentIndex].value) > 0) {
                this.swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = this.getParent(parentIndex);
            }
        } else if (haveChild && this.data[biggestChildIndex].value.compareTo(this.data[currentIndex].value) > 0) {
            while (biggestChildIndex >= 0 && this.data[currentIndex].value.compareTo(this.data[biggestChildIndex].value) < 0) {
                this.swap(currentIndex, biggestChildIndex);
                currentIndex = biggestChildIndex;
                biggestChildIndex = this.getBiggestChildIndex(currentIndex);
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        Entry<V> tmp = this.data[firstIndex];
        this.data[firstIndex] = this.data[secondIndex];
        this.data[secondIndex] = tmp;
    }

    private int getParent(int index) {
        if (index == 0) return -1;
        int parentIndex = (index - 1) / 2;
        return (parentIndex >= 0 && parentIndex < this.data.length) ? parentIndex : -1;
    }

    private int getBiggestChildIndex(int index) {
        int leftChildIndex = this.getLeftChild(index);
        int rightChildIndex = this.getRightChild(index);

        int biggestChildIndex = -1;
        if (leftChildIndex == -1 || this.data[leftChildIndex] == null) biggestChildIndex = rightChildIndex;
        else if (rightChildIndex == -1 || this.data[leftChildIndex] == null) biggestChildIndex = leftChildIndex;
        else
            biggestChildIndex = this.data[leftChildIndex].value.compareTo(this.data[rightChildIndex].value) > 0 ? leftChildIndex : rightChildIndex;

        return biggestChildIndex;
    }

    private int getLeftChild(int index) {
        int childIndex = index * 2 + 1;
        return (childIndex >= 0 && childIndex < this.data.length && this.data[childIndex] != null) ? childIndex : -1;
    }

    private int getRightChild(int index) {
        int childIndex = index * 2 + 2;
        return (childIndex >= 0 && childIndex < this.data.length && this.data[childIndex] != null) ? childIndex : -1;
    }

    private void grow() {
        Entry[] newData = new Entry[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        return Stream.of(this.data).filter(Objects::nonNull).map(Entry::toString).reduce((entry1, entry2) -> entry1 + ", " + entry2).orElseGet(() -> "[]");
    }

    private static class Entry<V> {
        V value;

        public Entry(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s", this.value);
        }
    }
}
