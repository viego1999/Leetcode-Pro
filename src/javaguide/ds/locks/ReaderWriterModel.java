package javaguide.ds.locks;


/**
 * 读写者模型是一种多线程同步的设计模式，它允许多个读线程同时访问共享资源，但只允许一个写线程访问该资源。使用自定义读写锁实现
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ReaderWriterModel
 * @since 2023/5/11 21:25
 */
@SuppressWarnings("all")
public class ReaderWriterModel {
    private static final int THREAD_COUNT = 18;
    private static final int READ_THREAD_COUNT = 15;
    private static final int WRITE_THREAD_COUNT = 3;

    private static final ReadWriteLock lock = new ReadWriteLock();
    private static int value = 0;


    public static void main(String[] args) {
        if (THREAD_COUNT != READ_THREAD_COUNT + WRITE_THREAD_COUNT) {
            throw new IllegalArgumentException("The thread_count != read_thread_count + write_thread_count!");
        }

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
                try {
                    lock.acquireReadLock();
                    System.out.println(Thread.currentThread().getName() + " reads value: " + value);
                    lock.releaseReadLock();

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
                try {
                    lock.acquireWriteLock();
                    value++;
                    System.out.println(Thread.currentThread().getName() + " writes value: " + value);
                    lock.releaseWriteLock();

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
