package javaguide.ds.advance.policy;

import javaguide.ds.advance.DefaultBlockingQueue;

/**
 * A handler for rejected tasks that throws a RejectedExecutionException.
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName AbortPolicy
 * @since 2023/5/11 23:57
 */
public class AbortPolicy<T> implements RejectPolicy<T> {
    @Override
    public void reject(DefaultBlockingQueue<T> queue, T task) {
        throw new RuntimeException("Task " + task.toString() +
                " rejected from " +
                queue.toString());
    }
}
