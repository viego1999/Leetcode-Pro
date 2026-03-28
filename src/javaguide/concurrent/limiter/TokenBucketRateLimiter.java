package javaguide.concurrent.limiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    // 桶的最大存放令牌数
    private final int capacity;
    // 放令牌的速度：每多少秒放 1 个
    private final long refillRate;

    // 上一次放令牌的时间
    private long lastRefillTime;
    // 当前桶里有多少令牌
    private int tokens;


    public TokenBucketRateLimiter(int capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 先加令牌，从上次到现在，该增加多少令牌
        int newTokens = (int) ((now - lastRefillTime) / 1000 * refillRate);
        if (newTokens > 0) {
            tokens = Math.min(capacity, tokens + newTokens);
            lastRefillTime = now;
        }
        // 有令牌就拿走一个，放行请求
        if (tokens > 0) {
            tokens--;
            System.out.println("tryAcquire success");
            return true;
        }
        // 没令牌，限流
        System.out.println("tryAcquire fail");
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter(3, 1);
        for (int i = 0; i < 15; i++) {
            if (tokenBucketRateLimiter.tryAcquire()) {
                System.out.println("执行任务");
            } else {
                System.out.println("被限流");
            }
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
