package javaguide.concurrent.limiter;

import java.util.function.Function;

/**
 * 固定窗口计数器限流
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName CounterLimiter
 * @since 2023/9/13 8:31
 */
public class CounterLimiter {
    private int count = 10;
    private final Object lock = new Object();


    public void tryAcquire() {
        try {
            synchronized (lock) {
                while (count <= 0) {
                    lock.wait();
                }
                count--;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tryRelease() {
        synchronized (lock) {
            count++;
            lock.notifyAll();
        }
    }

    public <T, R> R exec(Function<T, R> func, T t) {
        R r = null;

        try {
            synchronized (lock) {
                while (count <= 0) {
                    lock.wait();
                }
                count--;
                r = func.apply(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            synchronized (lock) {
                count++;
                lock.notifyAll();
            }
        }
        return r;
    }
}
