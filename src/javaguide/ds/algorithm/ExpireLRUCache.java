package javaguide.ds.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 带过期时间的 LRU 缓存类，采用惰性删除策略
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ExpireLRUCache
 * @since 2023/8/12 17:31
 */
public class ExpireLRUCache<K, V> {
    Map<K, Node<K, V>> map = new HashMap<>();
    Deque<K, V> deque = new Deque<>();
    int capacity;

    public ExpireLRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        deque.remove(node);
        if (isExpire(node)) {
            map.remove(node.key);
            return null;
        } else {
            // todo: 更新缓存时间？
            deque.addFirst(node);
            return node.val;
        }
    }

    public void put(K key, V val, long expireTime) {
        Node<K, V> node = new Node<>(key, val, expireTime);
        if (map.containsKey(node.key)) deque.remove(node);
        else {
            if (map.size() == capacity) {
                Node<K, V> last = deque.removeLast();
                map.remove(last.key);
            }
        }
        map.put(key, node);
        deque.addFirst(node);
    }


    public boolean isExpire(Node<K, V> node) {
        return System.currentTimeMillis() > node.expireTime;
    }

    static class Node<K, V> {
        K key;
        V val;
        Node<K, V> next, prev;
        long expireTime;

        public Node(K _key, V _val) {
            key = _key;
            val = _val;
        }

        public Node(K _key, V _val, long _expireTime) {
            this(_key, _val);
            expireTime = System.currentTimeMillis() + _expireTime;
        }
    }

    static class Deque<K, V> {
        Node<K, V> head, tail;

        public void addFirst(Node<K, V> node) {
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public void remove(Node<K, V> node) {
            if (head == tail) {
                head = tail = null;
            } else if (head == node) {
                head = head.next;
                node.next = head.prev = null;
            } else if (tail == node) {
                tail = tail.prev;
                node.prev = tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        public Node<K, V> removeLast() {
            Node<K, V> last = tail;
            remove(last);
            return last;
        }
    }
}
