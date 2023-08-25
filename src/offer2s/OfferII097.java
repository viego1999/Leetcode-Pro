package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII097
 * @since 2023/5/22 20:27
 */
public class OfferII097 {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}
