package javaguide.ds.queue;

/**
 * 队列接口类
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Queue
 * @since 2023/4/1 10:37
 */
public interface Queue<E> {

    boolean offer(E e);

    E poll();

    boolean isEmpty();

    default boolean isFull() {
        return false;
    }

    int size();

}
