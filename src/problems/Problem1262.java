package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1262
 * @since 2023/6/21 0:25
 */
public class Problem1262 {
    public static void main(String[] args) {

    }

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
        dp[0][1] = dp[0][2] = -0x3f3f3f3f;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j - nums[i - 1] % 3 + 3) % 3] + nums[i - 1]);
            }
        }
        return dp[n][0];
    }
}
