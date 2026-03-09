package javaguide.ds.advance.policy;

import javaguide.ds.advance.DefaultBlockingQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName DiscardPolicy
 * @since 2023/5/11 23:58
 */
public class DiscardPolicy<E> implements RejectPolicy<E> {
    @Override
    public void reject(DefaultBlockingQueue<E> queue, E task) {
    }
}
