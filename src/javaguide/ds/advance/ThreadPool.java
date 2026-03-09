package javaguide.ds.advance;

import javaguide.ds.advance.policy.RejectPolicy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ThreadPool
 * @since 2023/5/11 22:07
 */
public class ThreadPool {
    /**
     * 任务队列
     */
    private final BlockingQueue<Runnable> taskQueue;

    /**
     * 工作线程
     */
    private final Deque<Worker> workers = new ArrayDeque<>();

    /**
     * 核心线程数
     */
    private final int coreSize;

    /**
     * 超时时间
     */
    private final long timeout;

    /**
     * 时间单位
     */
    private final TimeUnit timeUnit;

    /**
     * 拒绝策略
     */
    private RejectPolicy<Runnable> rejectPolicy;


    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueSize, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new DefaultBlockingQueue<>(queueSize);
        this.rejectPolicy = rejectPolicy;

        for (int i = 0; i < coreSize; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker, "Worker-" + i).start();
        }
    }

    public void execute(Runnable task) {
        if (rejectPolicy == null) {
            taskQueue.put(task);
        } else {
            taskQueue.tryPut(rejectPolicy, task);
        }
    }

    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    public int getCoreSize() {
        return coreSize;
    }

    public void setRejectPolicy(RejectPolicy<Runnable> rejectPolicy) {
        this.rejectPolicy = rejectPolicy;
    }

    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Runnable task = taskQueue.poll(timeout, timeUnit);
                if (task != null) {
                    task.run();
                }
            }
        }

        public void shutdown() {
            this.running = false;
        }
    }
}
