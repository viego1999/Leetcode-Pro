package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem583
 * @since 2023/3/11 11:45
 */
public class Problem583 {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray(), cs2 = word2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[m][n];
    }
}
