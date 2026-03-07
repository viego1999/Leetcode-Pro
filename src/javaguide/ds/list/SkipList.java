package javaguide.ds.list;

import java.util.Random;

/**
 * SkipList class.
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName SkipList
 * @since 2023/4/8 17:22
 */
public class SkipList<E extends Comparable<E>> implements List<E> {
    private static final int MAX_LEVEL = 16; // 索引的最大层数
    private int levelCount = 1; // 索引的层级数
    private final Node<E> head = new Node<>(); // 头节点（不存储元素，相当于 dummy）
    private final Random random = new Random();
    private int size;

    @Override
    public boolean search(E e) {
        if (e == null) {
            throw new NullPointerException("The element e is null!");
        }
        Node<E> p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.next[i] != null && p.next[i].val.compareTo(e) < 0) {
                p = p.next[i];
            }
        }
        return p.next[0] != null && p.next[0].val.compareTo(e) == 0;
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("The element e is null!");
        }
        if (search(e)) return false;
        int level = randomLevel();
        Node<E> newNode = new Node<>(e);
        newNode.maxLevel = level;
        Node<E>[] update = new Node[level]; // 存储每层 新节点 的前驱节点，即小于 e 的最后一个节点
        for (int i = 0; i < level; i++) { // 初始都指向头节点
            update[i] = head;
        }
        Node<E> p = head;
        for (int i = level - 1; i >= 0; --i) { // 寻找每一层的小于 e 的最后一个节点
            while (p.next[i] != null && p.next[i].val.compareTo(e) < 0) {
                p = p.next[i];
            }
            update[i] = p;
        }
        // 更新每一层的newNode的next为前驱节点的next ，前驱节点的next为newNode
        for (int i = 0; i < level; ++i) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        // 更新当前跳表的最大索引层数
        if (levelCount < level) {
            levelCount = level;
        }
        size++;
        return true;
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public boolean delete(E e) {
        if (e == null) {
            throw new NullPointerException("The element e is null!");
        }
        Node<E>[] update = new Node[levelCount];
        Node<E> p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.next[i] != null && p.next[i].val.compareTo(e) < 0) {
                p = p.next[i];
            }
            update[i] = p;
        }
        if (p.next[0] != null && p.next[0].val.compareTo(e) == 0) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].next[i] != null && update[i].next[i].val.compareTo(e) == 0) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
            size--;
            return true;
        }
        return false;
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if ((random.nextInt() & 1) == 1) {
                level++;
            }
        }
        return level;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private static class Node<E extends Comparable<E>> {
        E val; // 节点的元素值
        Node<E>[] next = new Node[MAX_LEVEL];
        int maxLevel; // 当前节点的最大层数

        public Node() {}

        public Node(E e) {
            this.val = e;
        }
    }
}
