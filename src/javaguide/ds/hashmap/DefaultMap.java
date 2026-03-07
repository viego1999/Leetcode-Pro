package javaguide.ds.hashmap;

/**
 * @param <K> The type of the keys in this DefaultMap
 * @param <V> The type of the values in this DefaultMap
 * @author Xinyue Wu
 * @see java.util.Map
 * @since 1.8
 */
@SuppressWarnings("all")
public interface DefaultMap<K, V> {

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return If the key does not exist in the map, null is returned when the key is put,
     * otherwise if the key already exists in the map, the old value is returned when the key value is put.
     */
    public V put(K key, V value);

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public V get(K key);

    /**
     * @return The number of (key, value) pairs in this DefaultMap
     */
    public int size();

    /**
     * @return If this.size() = 0 is true, otherwise false
     */
    public boolean isEmpty();

    /**
     * Calculate the hash value of the key by perturbed hash algorithm.
     *
     * @param key The key to calculate the hash value.
     * @return Return the hash value of the key
     */
    default int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Internal Representation of every (key, value) pair in this DefaultMap
     */
    interface Entry<K, V> {

        public K getKey();

        public V getValue();

        public V setValue(V value);
    }
}
