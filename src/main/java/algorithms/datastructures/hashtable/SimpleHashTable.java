package algorithms.datastructures.hashtable;

public class SimpleHashTable<K, V> implements HashTable<K, V> {

    private Entry<K, V>[] table;
    private final double loadFactor;
    private int size;


    public SimpleHashTable(int initialCapacity, double loadFactor) {
        this.table = (Entry<K, V>[]) new Entry[initialCapacity];
        this.loadFactor = loadFactor;
    }

    public SimpleHashTable() {
        this(10, 0.75);
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        this.ensureCapacity();

        int index = this.getIndexFor(key);

        if (table[index] == null) {
            table[index] = newEntry;
            this.size++;
        } else {
            Entry<K, V> tmp = table[index];
            while (tmp.key.equals(key) || tmp.next != null) tmp = tmp.next;
            if (tmp.key.equals(key)) {
                tmp.value = value;
            } else {
                tmp.next = newEntry;
                this.size++;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = this.getIndexFor(key);
        Entry<K, V> tmp = table[index];
        while (tmp != null && !tmp.key.equals(key)) tmp = tmp.next;
        return tmp != null && tmp.key.equals(key) ? tmp.value : null;
    }

    @Override
    public V remove(K key) {
        int index = this.getIndexFor(key);
        Entry<K, V> tmp = table[index];
        if (tmp.key.equals(key)) {
            table[index] = tmp.next;
            size--;
            return tmp.value;
        } else {
            while (tmp.next != null && !tmp.next.key.equals(key)) tmp = tmp.next;
            if (tmp.next == null) {
                return null;
            } else {
                V val = tmp.next.value;
                tmp.next = tmp.next.next;
                size--;
                return val;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getIndexFor(Object object) {
        return object.hashCode() % this.table.length;
    }

    private void ensureCapacity() {
        if (this.size() > 0 && (double) this.size() / (double) table.length > this.loadFactor) {
            this.grow();
        }
    }

    private void grow() {
        Entry<?, ?>[] oldData = table;
        this.table = (Entry<K, V>[]) new Entry[oldData.length * 2];
        this.size = 0;
        for (Entry<?, ?> e : oldData) {
            while (e != null) {
                this.put((K) e.key, (V) e.value);
                e = e.next;
            }
        }
    }

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
