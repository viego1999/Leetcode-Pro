package javaguide.ds.blockqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基于 synchronized 关键字实现的阻塞队列
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName SynchronizedBlockingQueue
 * @since 2023/4/1 11:22
 */
public class SynchronizedBlockingQueue<E> implements BlockingQueue<E> {
    private final Deque<E> queue;
    private final int capacity;


    public SynchronizedBlockingQueue() {
        capacity = 10;
        queue = new ArrayDeque<>(capacity);
    }

    public SynchronizedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>(capacity);
    }

    @Override
    public void put(E e) throws InterruptedException {
        synchronized (queue) {
            /*
             * 为啥使用while循环判断，不使用if判断？
             *
             *    在使用if循环的时候会存在虚假唤醒，线程可以被唤醒，而不是被通知，中断或超时，即所谓的虚假唤醒，虽然正在实际操作中很少会发生，
             * 但是应用程序必须通过测试应该使用使线程被唤醒的条件来防范，并且如果条件不满足则继续等待，换句话说，等待应该出现的循环中。
             *
             *    在while循环里使用wait的目的，是在线程被唤醒的前后都持续检查条件是否被满足。生产者线程如果条件并未改变，那么这个线程并不能
             * 被唤醒，可以防止对缓冲区队列误操作。
             *
             *  https://blog.csdn.net/qfguan/article/details/121226964
             */
            while (queue.size() == capacity) {
                queue.wait(); // 如果队列已经满了，则进行等待
            }
            queue.add(e);
            queue.notifyAll();
        }
    }

    @Override
    public E take() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait(); // 如果队列为空，则进行等待
            }
            E e = queue.remove(); // 移除队列头部元素
            queue.notifyAll(); // 通知其他线程队列中有空闲位置
            return e;
        }
    }

    @Override
    public int size() {
        synchronized (queue) {
            return queue.size();
        }
    }
}
