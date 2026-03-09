package javaguide.ds.advance.policy;

import javaguide.ds.advance.DefaultBlockingQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName CallerRunsPolicy
 * @since 2023/5/11 23:58
 */
public class CallerRunsPolicy<T> implements RejectPolicy<T> {
    @Override
    public void reject(DefaultBlockingQueue<T> queue, T task) {
        if (task instanceof Runnable) {
            ((Runnable) task).run();
        }
    }
}
