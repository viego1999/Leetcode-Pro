package javaguide.concurrent.limiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 漏桶算法<p><a href="https://www.jb51.net/article/284213.htm">Java服务限流算法的6种实现</a>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName LeakyBucketRateLimiter
 * @since 2023/9/13 9:14
 */
public class LeakyBucketRateLimiter {
    // 桶的容量
    private final int capacity;
    // 当前桶内的水流量
    private final AtomicInteger water = new AtomicInteger();
    // 开始漏水的时间
    private long leakTimestamp;
    // 水流的速率（每秒通过的请求数）
    private final int leakRate;
    // exclusive lock
    private final Object lock = new Object();

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    public boolean tryAcquire() {
        synchronized (lock) {
            if (water.get() == 0) { // 如果当前桶中没有水，则重新开始计算
                System.out.println("start leaking");
                leakTimestamp = System.currentTimeMillis();
                return water.incrementAndGet() <= capacity;
            }
            // 先漏水，再计算剩余水流量
            // 需要漏的水流量
            int leakedWater = (int) ((System.currentTimeMillis() - leakTimestamp) / 1000 * leakRate);
            System.out.println("leakedWater: " + leakedWater);
            // 可能时间不足，则不进行漏水
            if (leakedWater != 0) {
                int leftWater = water.get() - leakedWater; // 剩余的水
                // 可能水已经漏光，设置为 0
                water.set(Math.max(0, leftWater));
                leakTimestamp = System.currentTimeMillis();
            }
            if (water.get() < capacity) {
                water.incrementAndGet();
                System.out.println("tryAcquire success");
                return true;
            } else {
                System.out.println("tryAcquire fail");
                return false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketRateLimiter leakyBucketRateLimiter = new LeakyBucketRateLimiter(3, 1);
        for (int i = 0; i < 15; i++) {
            if (leakyBucketRateLimiter.tryAcquire()) {
                System.out.println("执行任务");
            } else {
                System.out.println("被限流");
            }
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
