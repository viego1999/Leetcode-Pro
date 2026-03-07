package javaguide.ds.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于数组实现阻塞队列
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ArrayBlockingQueue
 * @since 2023/4/1 11:09
 */
public class ArrayBlockingQueue<E> implements BlockingQueue<E> {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final E[] items;
    private final int capacity;
    private int front, rear;
    private int count;


    @SuppressWarnings("unchecked")
    public ArrayBlockingQueue() {
        this.capacity = 10;
        items = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        items = (E[]) new Object[capacity];
    }

    @Override
    public void put(E e) throws InterruptedException {
        lock.lock(); // 获取锁
        try {
            while (count == capacity) { // 如果队列已满，等待 notFull 信号
                notFull.await();
            }
            items[rear] = e;
            rear = (rear + 1) % capacity;
            count++;
            notEmpty.signal(); // 发送 notEmpty 信号
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    @Override
    public E take() throws InterruptedException {
        lock.lock(); // 获取锁
        try {
            while (count == 0) { // 如果队列为空，等待 notEmpty 信号
                notEmpty.await();
            }
            E e = items[front];
            front = (front + 1) % capacity;
            count--;
            notFull.signal(); // 发送 notFull 信号
            return e;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    @Override
    public int size() {
        lock.unlock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
