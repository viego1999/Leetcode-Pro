package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1911
 * @since 2023/7/11 13:39
 */
public class Problem1911 {
    public static void main(String[] args) {

    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
