package javaguide.ds.list;

/**
 * List interface.
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName List
 * @since 2023/4/8 17:21
 */
public interface List<E extends Comparable<E>> {

    boolean search(E e);

    boolean add(E e);

    boolean delete(E e);

    int size();

    boolean isEmpty();

    String toString();

}
