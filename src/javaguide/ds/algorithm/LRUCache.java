package javaguide.ds.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName LRUCache
 * @since 2023/4/1 21:23
 */
public class LRUCache<K, V> implements Cache<K, V> {
    Map<K, Node<K, V>> map = new HashMap<>();
    Deque<K, V> deque = new Deque<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V val) {
        Node<K, V> node = new Node<>(key, val);
        if (map.containsKey(key)) deque.remove(map.get(key));
        else {
            if (map.size() == capacity) {
                Node<K, V> last = deque.removeLast();
                map.remove(last.key);
            }
        }
        map.put(key, node);
        deque.addFirst(node);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            deque.remove(node);
            deque.addFirst(node);
            return node.val;
        }
        return null;
    }

    private static class Node<K, V> {
        private K key;
        private V val;

        private Node<K, V> prev, next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class Deque<K, V> {
        private Node<K, V> head, tail;
        private int size = 0;

        public void add(Node<K, V> node) {
            if (size == 0) head = tail = node;
            else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
        }

        public void addFirst(Node<K, V> node) {
            if (size == 0) head = tail = node;
            else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        public void remove(Node<K, V> node) {
            if (size == 1) head = tail = null;
            else if (node == head) {
                head = head.next;
                node.next = head.prev = null;
            } else if (node == tail) {
                tail = tail.prev;
                node.prev = tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node<K, V> removeLast() {
            if (size > 0) {
                Node<K, V> node = tail;
                remove(node);
                return node;
            }
            return null;
        }
    }
}
