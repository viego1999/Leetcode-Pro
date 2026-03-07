package javaguide.ds.hashmap;

public class MyHashMap<K, V> implements DefaultMap<K, V> {
    /**
     * 负载因子
     */
    static final double loadFactor = 0.75;

    /**
     * 初始容量
     */
    static final int DEFAULT_CAPACITY = 16;

    /**
     * 链表数组
     */
    private MyEntry<K, V>[] table;

    /**
     * 大小
     */
    transient int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new MyEntry[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings({"unchecked", "unused"})
    public MyHashMap(int capacity) {
        table = new MyEntry[capacity];
        size = 0;
    }

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
    @Override
    public V put(K key, V value) {
        // 进行扩容
        if (size >= loadFactor * DEFAULT_CAPACITY) {
            resize();
        }
        // 计算哈希值
        int index = hash(key) & (table.length - 1);
        // 取出 index 位置的头节点
        MyEntry<K, V> entry = table[index];
        // 如果当前位置为空
        if (entry == null) {
            table[index] = new MyEntry<>(key, value);
        } else { // 如果当前位置已经有数据
            // 判断是否有重复的 key
            while (entry != null) {
                if (hash(entry.getKey()) == hash(key) && (entry.getKey() == key || entry.key.equals(key))) {
                    // 覆盖旧值并返回
                    return entry.setValue(value);
                }
                entry = entry.next;
            }
            // 如果没有重复的 key，则将当前节点插入到头部
            table[index] = new MyEntry<>(key, value, table[index]);
        }
        this.size++;
        return null;
    }

    /**
     * Initializes or doubles table size. If null, allocates in accord with initial capacity target
     * held in field threshold. Otherwise, because we are using power-of-two expansion, the elements
     * from each bin must either stay at same index, or move with a power of two offset in the new
     * table.
     */
    private void resize() {
        int oldCap = table.length, newCap = oldCap << 1;
        @SuppressWarnings("unchecked")
        MyEntry<K, V>[] newTable = new MyEntry[newCap];
        // 遍历数组所有元素，重新散列当前所有元素到 new table 中
        for (int i = 0; i < table.length; i++) {
            MyEntry<K, V> entry = table[i]; // 取出头节点
            while (entry != null) {
                // 计算当前节点新的哈希值
                int index = hash(entry.getKey()) & (newCap - 1);
                // 先取出当前节点的 后继节点
                MyEntry<K, V> next = entry.next;
                // 将当前节点插入到 new table [index] 的最前面
                entry.next = newTable[index];
                newTable[index] = entry;
                // 转移到下一个节点
                entry = next;
            }
        }
        table = newTable;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        // 计算对应的哈希值
        int index = hash(key) & (table.length - 1);
        // 遍历对应位置链表上的所有节点
        MyEntry<K, V> entry = table[index];
        while (entry != null) {
            if (hash(entry.key) == hash(key) && (entry.key == key || entry.key.equals(key))) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    static class MyEntry<K, V> implements DefaultMap.Entry<K, V> {
        K key;
        V value;
        MyEntry<K, V> next;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public MyEntry(K key, V value, MyEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
