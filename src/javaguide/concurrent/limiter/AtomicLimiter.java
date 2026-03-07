package javaguide.concurrent.limiter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName AtomicLimiter
 * @since 2023/9/13 8:15
 */
public class AtomicLimiter {
    private static final AtomicInteger ai = new AtomicInteger(10);

    public boolean tryAcquire() {
        if (ai.get() == 0) return false;
        ai.decrementAndGet();
        return true;
    }

    public void release() {
        ai.incrementAndGet();
    }
}
