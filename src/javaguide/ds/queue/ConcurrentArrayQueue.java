package javaguide.ds.queue;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 基于数组的循环队列
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ArrayQueue
 * @since 2023/4/1 10:15
 */
@SuppressWarnings("all")
public class ConcurrentArrayQueue<E> implements Queue<E> {
    /**
     * 锁
     */
    private final Object lock = new Object(); // 用于保证线程安全

    /**
     * 存储元素的数组
     */
    private E[] items;

    /**
     * 队列（数组）容量
     */
    private int capacity;

    /**
     * front - 指向当前队首元素位置 <p>
     * rear - 指向下一个元素存入位置
     */
    private int front, rear;


    public ConcurrentArrayQueue() {
        this.capacity = 10;
        items = (E[]) new Object[this.capacity];
    }

    public ConcurrentArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (E[]) new Object[this.capacity];
    }

    public boolean offer(E e) {
        synchronized (lock) {
            if ((rear + 1) % capacity == front) {
                return false;
            }
            items[rear] = e;
            rear = (rear + 1) % capacity;
            return true;
        }
    }

    public E poll() {
        synchronized (lock) {
            if (front == rear) {
                return null;
            }
            E item = items[front];
            front = (front + 1) % capacity;
            return item;
        }
    }

    public boolean isEmpty() {
        synchronized (lock) {
            return front == rear;
        }
    }

    public boolean isFull() {
        synchronized (lock) {
            return (rear + 1) % capacity == front;
        }
    }

    public int size() {
        synchronized (lock) {
            return (rear - front + capacity) % capacity;
        }
    }

    @Override
    public String toString() {
        synchronized (lock) {
            return '[' +
                    Arrays.stream(items)
                            .map((item) -> item != null ? item.toString() : "null")
                            .collect(Collectors.joining(", "))
                    + ']';
        }
    }
}
