package javaguide.concurrent.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于原子类实现的自定义读写锁
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ReadWriteLock
 * @since 2023/6/5 20:01
 */
public class ReadWriteLock {
    /**
     * 读锁数量
     */
    private final AtomicInteger writeCount = new AtomicInteger();
    /**
     * 写锁数量
     */
    private final AtomicInteger readCount = new AtomicInteger();


    public void tryReadLock() {
        while (true) {
            if (writeCount.get() == 0) { // 如果当前没有写锁
                readCount.incrementAndGet(); // 增加一把读锁
                return; // 直接返回
            }
            Thread.yield(); // 如果当前存在写锁，则让出cpu资源
        }
    }

    public void releaseReadLock() {
        readCount.decrementAndGet();
    }

    public void tryWriteLock() {
        // 如果当前存在写锁
        while (!writeCount.compareAndSet(0, 1)) {
            Thread.yield(); // 让出 cpu 资源
        }
        // 如果当前存在读锁
        while (readCount.get() > 0) {
            Thread.yield();
        }
    }

    public void releaseWriteLock() {
        writeCount.set(0);
    }
}
