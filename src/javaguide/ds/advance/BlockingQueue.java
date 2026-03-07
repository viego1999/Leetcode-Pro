package javaguide.ds.advance;

import ds.advance.policy.RejectPolicy;

import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列接口
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName BlockingQueue
 * @since 2023/5/24 21:00
 */
public interface BlockingQueue<E> {

    /**
     * 向阻塞队列中添加元素
     *
     * @param e 要添加的元素
     */
    void put(E e);

    /**
     * 向阻塞队列中添加元素，超过指定时间内未添加成功则不执行添加操作
     *
     * @param e 要添加的元素
     * @param timeout 指定时间
     * @param timeUnit 时间单位
     * @return 添加成功返回 true，失败 false
     */
    boolean offer(E e, long timeout, TimeUnit timeUnit);

    /**
     * 从队列中取出元素
     *
     * @return 返回取出的第一个元素
     */
    E take();

    E poll(long timeout, TimeUnit timeUnit);

    void tryPut(RejectPolicy<E> rejectPolicy, E e);

    int size();

}
