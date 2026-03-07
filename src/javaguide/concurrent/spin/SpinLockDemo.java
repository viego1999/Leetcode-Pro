package javaguide.concurrent.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 通过CAS操作完成自旋锁，t1线程先进来调用lock方法，自己持有锁3秒钟，t2线程随后进来发现
 * 当前有线程持有锁，不是null，所以只能通过自旋等待，直到t1释放锁后,t2再抢到锁
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "准备加锁...");
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(Thread.currentThread().getName() + "一直自旋，直到获得锁...");
        }
        System.out.println(Thread.currentThread().getName() + "退出..");
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "释放锁...");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }, "t1").start();

        Thread.sleep(2000);

        new Thread(() -> {
            spinLockDemo.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }, "t2").start();
    }
}
