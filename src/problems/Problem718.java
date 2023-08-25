package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem718
 * @since 2023/3/11 10:28
 */
public class Problem718 {
    public static void main(String[] args) {

    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
