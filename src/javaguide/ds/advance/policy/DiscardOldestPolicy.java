package javaguide.ds.advance.policy;

import ds.advance.DefaultBlockingQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName DiscardOldestPolicy
 * @since 2023/5/11 23:59
 */
public class DiscardOldestPolicy<E> implements RejectPolicy<E> {
    @Override
    public void reject(DefaultBlockingQueue<E> queue, E task) {
        E e = queue.take();
        queue.put(task);
    }
}
