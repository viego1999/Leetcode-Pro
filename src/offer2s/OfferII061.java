package offer2s;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII061
 * @since 2023/5/11 12:33
 */
public class OfferII061 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> nums1[x[0]] + nums2[x[1]] - nums1[y[0]] - nums2[y[1]]);
        int m = nums1.length, n = nums2.length, o = Math.min(m, k);
        for (int i = 0; i < o; i++) pq.offer(new int[]{i, 0});
        while (k-- > 0 && !pq.isEmpty()) {
            int[] poll = pq.poll();
            ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            if (poll[1] + 1 < n) pq.offer(new int[]{poll[0], poll[1] + 1});
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairsBf(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> x.get(0) + x.get(1) - y.get(0) - y.get(1));
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                pq.offer(Arrays.asList(num1, num2));
            }
        }
        while (!pq.isEmpty() && k-- > 0) ans.add(pq.poll());
        return ans;
    }
}
