package javaguide.concurrent.limiter;


import java.util.PriorityQueue;

public class SlidingWindowRateLimiter {
    private final long limits;
    private final long windowSize;

    private final PriorityQueue<Long> queue = new PriorityQueue<>();


    public SlidingWindowRateLimiter(long limits, long windowSize) {
        this.limits = limits;
        this.windowSize = windowSize;
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        long expireTime = now - windowSize;
        while (!queue.isEmpty() && queue.peek() < expireTime) queue.poll();

        if (queue.size() < limits) {
            queue.offer(now);
            return true;
        }

        return false;
    }
}
