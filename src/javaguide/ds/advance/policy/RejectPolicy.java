package javaguide.ds.advance.policy;

import ds.advance.DefaultBlockingQueue;

/**
 * 拒绝策略
 * <pre>
 *     1) 死等
 *     2) 带超时等待
 *     3) 让调用者放弃任务执行
 *     4) 让调用者抛出异常
 *     5) 让调用者自己执行任务
 * </pre>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName RejectPolicy
 * @since 2023/5/11 23:15
 */
@FunctionalInterface
public interface RejectPolicy<T> {

    void reject(DefaultBlockingQueue<T> queue, T task);

}
