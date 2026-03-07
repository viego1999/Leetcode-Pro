package javaguide.concurrent.printab;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName SynchronizedPrintAB
 * @since 2023/7/15 8:44
 */
public class SynchronizedPrintAB {
    private static final Object lock = new Object();
    private static volatile int allCnt = 0;

    public static void main(String[] args) {
        new A().start();
        new B().start();
    }

    static class A extends Thread {
        volatile int cnt = 0;

        @Override
        public void run() {
            while (cnt < 5) {
                synchronized (lock) {
                    try {
                        while ((allCnt & 1) == 1) { // 奇数则等待 B 线程打印完
                            lock.wait();
                        }
                        System.out.println("A");
                        allCnt++;
                        cnt++;
                        lock.notify(); // 打印完通知 B 线程
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    static class B extends Thread {
        volatile int cnt = 0;

        @Override
        public void run() {
            while (cnt < 5) {
                synchronized (lock) {
                    try {
                        while ((allCnt & 1) == 0) { // 偶数则等待 A 线程打印
                            lock.wait();
                        }
                        System.out.println("B");
                        allCnt++;
                        cnt++;
                        lock.notify(); // 通知 A 线程打印
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
