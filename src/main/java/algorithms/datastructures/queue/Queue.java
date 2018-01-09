package algorithms.datastructures.queue;

public interface Queue<T> {
    void add(T item);
    T remove();
    T peek();
}
