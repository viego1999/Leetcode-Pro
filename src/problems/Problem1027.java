package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1027
 * @since 2023/4/22 12:05
 */
public class Problem1027 {
    public static void main(String[] args) {

    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] dp = new int[n][500 * 2 + 5];
        for (int[] ints: dp) Arrays.fill(ints, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int sub = nums[i] - nums[j] + 500;
                dp[i][sub] = Math.max(dp[i][sub], dp[j][sub] + 1);
                ans = Math.max(ans, dp[i][sub]);
            }
        }
        return ans;
    }
}
