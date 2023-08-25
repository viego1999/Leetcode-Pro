package offer2s;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII042
 * @since 2023/4/30 20:12
 */
public class OfferII042 {
    public static void main(String[] args) {

    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    static class RecentCounter {
        Queue<Integer> queue = new ArrayDeque<>();

        public RecentCounter() { }

        public int ping(int t) {
            while (!queue.isEmpty() && t - queue.peek() > 3000) queue.poll();
            queue.offer(t);
            return queue.size();
        }
    }
}
