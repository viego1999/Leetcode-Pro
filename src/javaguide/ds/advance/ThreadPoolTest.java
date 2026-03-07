package javaguide.ds.advance;

import ds.advance.policy.DiscardOldestPolicy;

import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池类测试
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ThreadPoolTest
 * @since 2023/5/11 23:30
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(8, 0L, TimeUnit.SECONDS, 10, (queue, task) -> {
            // 1. 死等
            // queue.put(task);
            // 2) 带超时等待
            // queue.offer(task, 1500, TimeUnit.MILLISECONDS);
            // 3) 让调用者放弃任务执行
            // log.debug("放弃{}", task);
            // 4) 让调用者抛出异常
            // throw new RuntimeException("任务执行失败 " + task);
            // 5) 让调用者自己执行任务
            task.run();
        });

        for (int i = 0; i < 4; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(j);
            });
        }

        threadPool.setRejectPolicy(new DiscardOldestPolicy<>());

        for (int i = 0; i < 10; i++) {
            int j = i;
            threadPool.execute(() -> {
                System.out.println("j = " + j);
            });
        }

        threadPool.shutdown();
    }
}
