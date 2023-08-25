package offer2s;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII031
 * @since 2023/4/25 22:05
 */
public class OfferII031 {
    public static void main(String[] args) {

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * <pre>{@code
     *  LRUCache obj = new LRUCache(capacity);
     *  int param_1 = obj.get(key);
     *  obj.put(key,value);
     * }</pre>
     */
    static class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        Deque deque = new Deque();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            deque.remove(node);
            deque.addFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) deque.remove(map.get(key));
            else if (capacity == map.size()) {
                Node last = deque.removeLast();
                map.remove(last.key);
            }
            deque.addFirst(node);
            map.put(key, node);
        }

        static class Node {
            int key, val;
            Node prev, next;

            public Node(int _key, int _val) {
                key = _key;
                val = _val;
            }
        }

        static class Deque {
            Node head, tail;

            public void addFirst(Node node) {
                if (head == tail && head == null) head = tail = node;
                else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
            }

            public void remove(Node node) {
                if (node == head && node == tail) head = tail = null;
                else if (node == head) {
                    head = head.next;
                    head.prev = node.next = null;
                } else if (node == tail) {
                    tail = tail.prev;
                    tail.next = node.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }

            public Node removeLast() {
                if (head == tail && head == null) return null;
                Node last = tail;
                remove(last);
                return last;
            }
        }
    }
}
