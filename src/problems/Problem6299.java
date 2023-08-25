package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6299
 * @since 2023/1/22 11:34
 */
public class Problem6299 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 3, 3};
        System.out.println(minCost(nums, 2));
    }

    public static int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int[] cnts = new int[n + 1];
            for (int j = i - 1, t = 0; j >= 0; j--) {
                int x = ++cnts[nums[j]];
                if (x == 2) t += 2;
                else if (x > 2) t++;
                dp[i] = Math.min(dp[i], dp[j] + k + t);
            }
        }
        return dp[n];
    }
}
