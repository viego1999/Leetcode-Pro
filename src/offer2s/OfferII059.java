package offer2s;

import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII059
 * @since 2023/5/7 10:16
 */
public class OfferII059 {
    public static void main(String[] args) {

    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    static class KthLargest {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }
}
