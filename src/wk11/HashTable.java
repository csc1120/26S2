package wk11;

import java.util.LinkedList;
import java.util.List;

public class HashTable<E> {
    private List<E>[] buckets;
    private int size;
    public static final int DEFAULT_CAPACITY = 5;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        buckets = new List[capacity];
        size = 0;
    }

    public boolean contains(Object target) {
        boolean found = false;
        if (target != null) {
            List<E> bucket = buckets[Math.abs(target.hashCode()) % buckets.length];
            found = bucket != null && bucket.contains(target);
        }
        return found;
    }

    public boolean add(E element) {
        if (element == null) {
            throw new IllegalArgumentException("HashTable does not accept null elements");
        }
        boolean found = contains(element);
        if (!found) {
            int bucketIndex = Math.abs(element.hashCode()) % buckets.length;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new LinkedList<>();
            }
            buckets[bucketIndex].add(element);
            ++size;
        }
        return !found;
    }

}
