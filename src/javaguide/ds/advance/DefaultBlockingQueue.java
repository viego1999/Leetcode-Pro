package javaguide.ds.advance;

import javaguide.ds.advance.policy.RejectPolicy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义阻塞队列实现
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName DefaultBlockingQueue
 * @since 2023/5/11 22:46
 */
public class DefaultBlockingQueue<E> implements BlockingQueue<E> {
    private final Deque<E> queue = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final int capacity;


    public DefaultBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(E e) {
        try {
            lock.lock();
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(e);
            notEmpty.signal();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit timeUnit) {
        try {
            lock.lock();
            while (queue.size() == capacity) {
                if (!notFull.await(timeout, timeUnit)) return false;
            }
            queue.add(e);
            notEmpty.signal();
            return true;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E take() {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            E e = queue.removeFirst();
            notFull.signal();
            return e;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout, TimeUnit timeUnit) {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                if (notEmpty.await(timeout, timeUnit)) return null;
            }
            E e = queue.removeFirst();
            notFull.signal();
            return e;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void tryPut(RejectPolicy<E> rejectPolicy, E e) {
        try {
            lock.lock();
            if (queue.size() == capacity) { // 队列满了
                rejectPolicy.reject(this, e);
            } else { // 没有满
                queue.add(e);
                notEmpty.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.lock();
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
