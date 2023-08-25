package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII098
 * @since 2023/5/22 20:33
 */
public class OfferII098 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
