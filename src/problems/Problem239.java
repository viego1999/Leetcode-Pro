package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[queue.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k) queue.pollFirst();
            ans[i - k + 1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
