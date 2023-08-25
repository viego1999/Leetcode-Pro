package problems;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1226
 * @since 2023/5/17 11:01
 */
public class Problem1226 {
    public static void main(String[] args) {

    }

    static class DiningPhilosophersSemaphore {
        private final ReentrantLock[] locks = new ReentrantLock[5];
        private final Semaphore semaphore = new Semaphore(4);

        public DiningPhilosophersSemaphore() {
            for (int i = 0; i < locks.length; i++) {
                locks[i] = new ReentrantLock();
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = (philosopher + 4) % 5, right = philosopher;

            semaphore.acquire();

            locks[left].lock();
            locks[right].lock();

            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();

            locks[right].unlock();
            locks[left].unlock();

            semaphore.release();
        }
    }

    static class DiningPhilosophersReentrantLock {
        private final ReentrantLock[] locks = new ReentrantLock[5];

        public DiningPhilosophersReentrantLock() {
            for (int i = 0; i < locks.length; i++) {
                locks[i] = new ReentrantLock();
            }
        }

        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = (philosopher + 4) % 5, right = philosopher;
            // 为偶数的哲学家优先获取右边的筷子
            if ((philosopher & 1) == 0) {
                locks[right].lock();
                locks[left].lock();
            } else {
                locks[left].lock();
                locks[right].lock();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();

            locks[left].unlock();
            locks[right].unlock();
        }
    }
}
