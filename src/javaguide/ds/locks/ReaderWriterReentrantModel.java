package javaguide.ds.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写者模型是一种多线程同步的设计模式，它允许多个读线程同时访问共享资源，但只允许一个写线程访问该资源。基于 ReentrantReadWriteLock 实现
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ReaderWriterModel
 * @since 2023/5/11 21:25
 */
public class ReaderWriterReentrantModel {
    private static final int THREAD_COUNT = 18;
    private static final int READ_THREAD_COUNT = 15;
    private static final int WRITE_THREAD_COUNT = 3;

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int value = 0;


    public static void main(String[] args) {
        for (int i = 0; i < READ_THREAD_COUNT; i++) {
            new Thread(new Reader()).start();
        }

        for (int i = 0; i < WRITE_THREAD_COUNT; i++) {
            new Thread(new Writer()).start();
        }
    }

    static class Reader implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " reads value: " + value);
                lock.readLock().unlock();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Writer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.writeLock().lock();
                value++;
                System.out.println(Thread.currentThread().getName() + " writes value: " + value);
                lock.writeLock().unlock();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
