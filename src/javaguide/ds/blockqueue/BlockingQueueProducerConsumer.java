package javaguide.ds.blockqueue;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基于阻塞队列实现生产者消费者模型
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ProducerConsumer
 * @since 2023/4/1 11:37
 */
public class BlockingQueueProducerConsumer {
    private static final int BUFFER_SIZE = 10;
    private static final BlockingQueue<String> queue = new SynchronizedBlockingQueue<>(BUFFER_SIZE);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                int i = 0;
                while (true) {
                    String item = "item_" + i++;
                    System.out.println("Produced: " + item + "\t" + format.format(new Date()));
                    queue.put(item); // 将 item 放入阻塞队列中
                    Thread.sleep(1000); // 生成速度为1s一个
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    String item = queue.take();

                    System.out.println("Consumed: " + item + "\t" + format.format(new Date()));
                    Thread.sleep(2000); // 消费速度为 2s 一个
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
