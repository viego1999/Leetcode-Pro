package javaguide.concurrent.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {
//    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    private static final ExecutorService esSingle = Executors.newSingleThreadExecutor();
    private static final ExecutorService esFixed = Executors.newFixedThreadPool(10);
    private static final ExecutorService esCached = Executors.newCachedThreadPool();
    private static final ExecutorService esScheduled = Executors.newScheduledThreadPool(10);
    private static final ExecutorService esWorkStealing = Executors.newWorkStealingPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start.");
        esFixed.execute(() -> {});
        Future<?> future = esFixed.submit(Object::new);
        System.out.println(future.get());
        System.out.println("end.");
    }
}
