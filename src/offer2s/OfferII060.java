package offer2s;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII060
 * @since 2023/5/8 0:00
 */
public class OfferII060 {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = pq.poll()[0];
        return ans;
    }
}
