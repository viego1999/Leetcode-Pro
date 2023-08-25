package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2357
 * @since 2023/2/24 0:09
 */
public class Problem2357 {
    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        return set.size();
    }

    public int minimumOperations_(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) if (num > 0) pq.offer(num);
        int ans = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                int t = pq.poll() - x;
                if (t > 0) list.add(t);
            }
            list.forEach(pq::offer);
            ans++;
        }
        return ans;
    }
}
