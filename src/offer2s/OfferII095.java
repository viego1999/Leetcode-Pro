package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII095
 * @since 2023/5/22 19:04
 */
public class OfferII095 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] cs1 = text1.toCharArray(), cs2 = text2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
