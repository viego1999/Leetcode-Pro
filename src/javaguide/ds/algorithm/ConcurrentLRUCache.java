package javaguide.ds.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ConcurrentLRUCache class.
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ConcurrentLRUCache
 * @since 2023/4/2 20:49
 */
public class ConcurrentLRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<K, V> cache = new LinkedHashMap<K, V>(16, 0.75F, true) {
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    };

    public ConcurrentLRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        try {
            lock.writeLock().lock();
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public V get(K key) {
        try {
            lock.readLock().lock();
            return cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }
}
