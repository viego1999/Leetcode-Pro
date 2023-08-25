package problems;

import java.util.Deque;
import java.util.LinkedList;

public class Problem862 {
    public static void main(String[] args) {

    }

    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = nums[i] + s[i];
        }
        q.offerLast(0); // 先存入一个0
        int res = -1, pos = -1; // pos记录目前最优解的下标
        for (int i = 1; i < s.length; i++) { // 遍历前缀和数组
            while (!q.isEmpty() && s[i] - s[q.peekFirst()] >= k) {
                pos = q.pollFirst(); // 更新j下标
            }
            // 如果pos有值 且i-pos比当前的最优解还要小 则更新最优解
            if (pos != -1 && (i - pos < res || res == -1)) res = i - pos;
            while (!q.isEmpty() && s[i] < s[q.peekLast()]) {
                q.pollLast(); // 舍弃当前值
            }
            q.offerLast(i);
        }
        return res;
    }
}
