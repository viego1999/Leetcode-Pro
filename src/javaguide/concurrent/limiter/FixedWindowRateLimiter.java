package javaguide.concurrent.limiter;

public class FixedWindowRateLimiter {
    private final int limit; // 窗口内最大允许请求数
    private final long windowSize; // 窗口大小（毫秒）

    private long windowStart; // 当前窗口的开始时间
    private int count; // 当前窗口的请求次数

    public FixedWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 如果当前时间已经超过上一个窗口，就重置窗口
        if (now - windowStart > windowSize) {
            windowStart = now;
            count = 0;
        }

        // 如果还没超过上限，运行请求
        if (count < limit) {
            count++;
            return true;
        }
        // 超过上限，限流
        return false;
    }
}
