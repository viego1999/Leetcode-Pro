package javaguide.concurrent.printab;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印 AB 各50次
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName PrintAB
 * @since 2023/7/15 8:29
 */
public class PrintAB {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition aCondition = lock.newCondition();
    private static final Condition bCondition = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {
        new A().start();
        Thread.sleep(1);
        new B().start();
    }

    static class A extends Thread {
        private volatile int cnt = 0;

        public void run() {
            while (cnt < 5) {
                try {
                    lock.lock();
                    System.out.println("A");
                    cnt++;
                    bCondition.signal();
                    aCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class B extends Thread {
        private volatile int cnt = 0;

        @Override
        public void run() {
            while (cnt < 5) {
                try {
                    lock.lock();
                    System.out.println("B");
                    cnt++;
                    aCondition.signal();
                    bCondition.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
