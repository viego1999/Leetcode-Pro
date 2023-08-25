package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1186
 * @since 2023/6/28 0:09
 */
public class Problem1186 {
    public static void main(String[] args) {

    }

    public int maximumSum(int[] arr) {
        int n = arr.length, ans = -0x3f3f3f3f;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = dp[0][1] = ans;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i - 1], arr[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i - 1], dp[i - 1][0]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
