package algorithms.datastructures.hashtable;

public interface HashTable<K, V> {
    void put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean contains(K key);
    int size();
}
