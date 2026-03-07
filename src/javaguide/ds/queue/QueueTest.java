package javaguide.ds.queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName QueueTest
 * @since 2023/4/1 10:29
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> aq = new ConcurrentArrayQueue<>();
        for (int i = 0; i < 11; i++) System.out.println("offer: " + aq.offer(i));
        System.out.println(aq);
    }
}
