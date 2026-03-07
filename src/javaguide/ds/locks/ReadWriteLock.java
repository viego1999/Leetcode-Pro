package javaguide.ds.locks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于 AtomicInteger 实现的读写锁
 * @author Wuxy
 * @version 1.0
 * @ClassName ReadWriteLock
 * @since 2023/5/11 21:40
 */
public class ReadWriteLock {
    private final AtomicInteger writeCount = new AtomicInteger(0);
    private final AtomicInteger readCount = new AtomicInteger(0);


    public void acquireReadLock() throws InterruptedException {
        while (true) {
            int readers = readCount.get();
            if (writeCount.get() > 0) {
//                Thread.sleep(100); // 等待写锁释放
                Thread.yield(); // 让出当前cpu使用权
                continue;
            }
            if (readCount.compareAndSet(readers, readers + 1)) {
                return;
            }
        }
    }

    public void releaseReadLock() {
        readCount.decrementAndGet();
    }

    public void acquireWriteLock() throws InterruptedException {
        while (!writeCount.compareAndSet(0, 1)) {
            Thread.sleep(100); // 等待写锁释放
        }
        while (readCount.get() > 0) {
            Thread.sleep(100); // 等待读锁释放
        }
    }

    public void releaseWriteLock() {
        writeCount.set(0);
    }
}
