package offer2s;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII100
 * @since 2023/5/22 21:14
 */
public class OfferII100 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), ans = 0x3f3f3f3f;
        int[][] dp = new int[n][n];
        for (int[] ints : dp) Arrays.fill(ints, ans);
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int v = triangle.get(i).get(j);
                if (j == 0) dp[i][j] = dp[i - 1][j] + v;
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + v;
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + v;
            }
        }
        for (int i = 0; i < n; i++) ans = Math.min(ans, dp[n - 1][i]);
        return ans;
    }
}
