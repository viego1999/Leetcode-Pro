package javaguide.ds.locks;

/**
 * 基于 synchronized 关键字实现读写锁
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName SynchronizedReadWriteLock
 * @since 2023/6/5 20:12
 */
public class SynchronizedReadWriteLock {
    /**
     * 互斥资源锁
     */
    private final Object lock = new Object();

    private int writeCount = 0;

    private int readCount = 0;


    public void tryReadLock() throws InterruptedException {
        synchronized (lock) {
            while (writeCount > 0) {
                lock.wait();
            }
            readCount++;
        }
    }

    public void releaseReadLock() {
        synchronized (lock) {
            if (readCount == 0) {
                throw new IllegalStateException("Current thread don't acquire read lock.");
            }
            readCount--;
            lock.notifyAll();
        }
    }

    public void tryWriteLock() throws InterruptedException {
        synchronized (lock) {
            while (writeCount > 0 || readCount > 0) {
                lock.wait();
            }
            writeCount++;
        }
    }

    public void releaseWriteLock() {
        synchronized (lock) {
            if (writeCount == 0) {
                throw new IllegalStateException("Current thread don't acquire write lock.");
            }
            writeCount--;
            lock.notifyAll();
        }
    }
}
