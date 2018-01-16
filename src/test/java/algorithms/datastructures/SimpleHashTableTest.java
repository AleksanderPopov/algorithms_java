package algorithms.datastructures;

import algorithms.datastructures.hashtable.HashTable;
import algorithms.datastructures.hashtable.SimpleHashTable;

import static org.junit.Assert.assertEquals;

public class SimpleHashTableTest {
    @org.junit.Test
    public void test0() {
        HashTable<String, Integer> simpleHashTable = new SimpleHashTable<>();

        for (int i = 0; i < 100; i++) {
            String key = String.valueOf(Character.valueOf((char) i)) + i;
            Integer value = i;
            simpleHashTable.put(key, value);
            assertEquals(value, simpleHashTable.get(key));
            assertEquals(i + 1, simpleHashTable.size());
        }

        for (int i = 99; i >= 0; i--) {
            String key = String.valueOf(Character.valueOf((char) i)) + i;
            Integer value = i;
            assertEquals(true, simpleHashTable.contains(key));
            assertEquals(value, simpleHashTable.remove(key));
            assertEquals(i, simpleHashTable.size());
        }

        System.out.println("az".hashCode());
        System.out.println("za".hashCode());
    }
}
