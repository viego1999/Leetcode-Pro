package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2735
 * @since 2023/6/12 11:06
 */
public class Problem2735 {
    public static void main(String[] args) {

    }

    public long minCost(int[] nums, int x) {
        long ans = (long) 1e15;
        int[] array = nums.clone();
        for (int i = 0, n = nums.length; i < n; i++) {
            long cost = 0;
            for (int j = 0; j < n; j++) {
                array[j] = Math.min(array[j], nums[(i + j) % n]);
                cost += array[j];
            }
            ans = Math.min(ans, cost + (long) i * x);
        }
        return ans;
    }
}
