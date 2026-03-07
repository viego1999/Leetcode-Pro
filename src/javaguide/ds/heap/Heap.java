package javaguide.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 大顶堆实现
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Heap
 * @since 2023/3/17 15:37
 */
public class Heap<E extends Comparable<E>> implements PriorityQueue<E> {

    private final List<E> elems;
    private Comparator<E> comparator;

    public Heap() {
        elems = new ArrayList<>();
        comparator = Comparable::compareTo;
    }

    public Heap(Comparator<E> comparator) {
        elems = new ArrayList<>();
        this.comparator = comparator;
    }

    public Heap(List<E> elems) {
        this.elems = new ArrayList<>();
        for (E elem : elems) {
            this.add(elem);
        }
    }

    @Override
    public void add(E e) {
        int index = elems.size();
        elems.add(index, e);
        shiftUp(index);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("No such element!");
        }
        return elems.get(0);
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("No such element!");
        }
        E rootElem = elems.get(0); // 得到根元素
        E lastElem = elems.remove(elems.size() - 1); // 移除最后一个元素
        if (elems.size() > 0) {
            // 将最后一个元素放到根位置
            elems.set(0, lastElem);
            // 向下调整
            shiftDown(0);
        }
        return rootElem;
    }

    /**
     * Inserts item x at position k, maintaining ds.heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     * <p>
     * To simplify and speed up coercions and comparisons. the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     *
     * @param index the position to fill
     */
    private void shiftUp(int index) {
        // 当前要调整的元素
        E temp = elems.get(index);
        // 如果当前索引不为根节点，并且当前节点元素大于其父节点: parent = (child - 1) >> 1
        for (; index > 0 && comparator.compare(temp, elems.get((index - 1) >>> 1)) > 0; index = (index - 1) >>> 1) {
            // 交换当前节点与父节点的值
            swap(index, (index - 1) >>> 1);
        }
    }

    /**
     * Inserts item x at position k, maintaining ds.heap invariant by
     * demoting x down the tree repeatedly until it is less than or
     * equal to its children or is a leaf.
     *
     * @param index the position to fill
     * @param x     the item to insert
     */
    @SuppressWarnings("all")
    private void shiftDown(int index) {
        E temp = elems.get(index);
        // 向下调整，开始令 k 为 index 的左孩子: leftChild = (parent << 1) + 1
        for (int k = (index << 1) + 1; k < elems.size(); k = (k << 1) + 1) {
            // 选择左孩子和右孩子中的最大者
            if (k < elems.size() - 1 && comparator.compare(elems.get(k), elems.get(k + 1)) < 0) {
                k++;
            }
            // 如果其孩子节点的值比父节点大
            if (comparator.compare(temp, elems.get(k)) < 0) {
                // 与孩子节点交互值
                swap(index, k);
                // 更新index为交换后的位置
                index = k;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = elems.get(i);
        elems.set(i, elems.get(j));
        elems.set(j, temp);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray() {
        return (T[]) elems.toArray();
    }

    @Override
    public int size() {
        return elems.size();
    }

    @Override
    public boolean isEmpty() {
        return elems.isEmpty();
    }
}
