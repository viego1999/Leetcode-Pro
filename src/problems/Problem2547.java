package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2547
 * @since 2023/3/4 20:55
 */
public class Problem2547 {
    public static void main(String[] args) {

    }

    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int[] cnts = new int[1001];
            for (int j = i - 1, t = 0; j >= 0; j--) {
                int x = ++cnts[nums[j]];
                if (x == 2) t += 2;
                else if (x > 2) t += 1;
                dp[i] = Math.min(dp[i], dp[j] + k + t);
            }
        }
        return dp[n];
    }
}
