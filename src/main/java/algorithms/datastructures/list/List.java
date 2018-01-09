package algorithms.datastructures.list;

public interface List<T> {
    void add(T item);
    T set(int index, T item);
    T get(int index);
    void remove(int index);
    int size();
    boolean contains(T item);
}
