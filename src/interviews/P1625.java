package interviews;

import java.util.HashMap;
import java.util.Map;

public class P1625 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(16);
        cache.put(1, 2);
    }


    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    static class LRUCache {
        DLinkedList list = new DLinkedList();
        Map<Integer, Node> map = new HashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                list.remove(node);
                list.addFirst(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) list.remove(map.get(key));
            else {
                if (list.size == capacity)
                    map.remove(list.removeLast().key);
            }
            map.put(key, node);
            list.addFirst(node);
        }

        static class Node {
            int key, val;
            Node prev, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        static class DLinkedList {
            int size = 0;
            Node head, tail;

            public void add(Node node) {
                if (size == 0) head = tail = node;
                else {
                    tail.next = node;
                    node.prev = tail;
                    tail = tail.next;
                }
                size++;
            }

            public void addFirst(Node node) {
                if (size == 0) head = tail = node;
                else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
                size++;
            }

            public void remove(Node node) {
                if (size == 1) {
                    head = tail = null;
                } else if (node == head) {
                    head = head.next;
                    node.next = head.prev = null;
                } else if (node == tail) {
                    tail = tail.prev;
                    tail.next = node.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                size--;
            }

            public Node removeLast() {
                if (size > 0) {
                    Node node = tail;
                    remove(node);
                    return node;
                }
                return null;
            }
        }
    }
}
