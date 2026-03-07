package javaguide.ds.bst;

import java.util.Comparator;

/**
 * 二叉搜索树实现类
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName BST
 * @since 2023/3/26 23:56
 */
public class BST<E extends Comparable<E>> {

    private final Comparator<E> comparator;

    private int size;

    private Node<E> root;

    public BST() {
        comparator = Comparator.naturalOrder();
        this.size = 0;
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
        this.size = 0;
    }

    public boolean add(E e) {
        int beginSize = this.size;

        this.root = add(this.root, e);

        return this.size > beginSize;
    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            this.size++;
            return new Node<>(e);
        }

        int comp = comparator.compare(node.e, e);

        if (comp < 0) {
            node.right = add(node.right, e);
        } else if (comp > 0) {
            node.left = add(node.left, e);
        }

        return node;
    }

    public boolean search(E e) {
        if (this.size == 0) return false;

        return search(root, e);
    }

    private boolean search(Node<E> node, E e) {
        if (node == null) return false;

        int comp = comparator.compare(node.e, e);
        if (comp == 0) {
            return true;
        } else if (comp < 0) {
            return search(node.right, e);
        } else {
            return search(node.left, e);
        }
    }

    public boolean delete(E e) {
        if (this.size == 0) return false;

        int beginSize = this.size;

        this.root = delete(this.root, e);

        return this.size < beginSize;
    }

    private Node<E> delete(Node<E> node, E e) {
        if (node == null) {
            return null;
        }

        int comp = comparator.compare(node.e, e);

        if (comp > 0) {
            node.left = delete(node.left, e);
        } else if (comp < 0) {
            node.right = delete(node.right, e);
        } else {
            if (node.left != null && node.right != null) { // 有两个孩子
                // 找到node节点的前驱，也就是最大的小于node.val的节点
                Node<E> cur = node.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                // 将值进行交换
                node.e = cur.e;
                // 删除这个前驱节点的位置
                node.left = delete(node.left, e);
            } else {
                this.size--;
                if (node.left != null) {
                    return node.left;
                } else if (node.right != null) {
                    return node.right;
                } else {
                    return null;
                }
            }
        }

        return node;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private static class Node<E extends Comparable<E>> {
        E e;

        Node<E> left, right;

        public Node() {

        }

        public Node(E e) {
            this.e = e;
        }
    }
}

