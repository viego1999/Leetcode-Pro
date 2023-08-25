package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6404
 * @since 2023/4/29 22:44
 */
public class Problem6404 {
    public static void main(String[] args) {

    }

    public long countOperationsToEmptyArrayBf(int[] nums) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            pq.offer(num);
            deque.addLast(num);
        }
        while (!deque.isEmpty()) {
            int first = deque.removeFirst();
            if (first == pq.peek()) {
                pq.poll();
            } else {
                deque.addLast(first);
            }
            ans++;
        }
        return ans;
    }
}
