package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII096
 * @since 2023/5/22 19:53
 */
public class OfferII096 {
    public static void main(String[] args) {

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray(), cs3 = s3.toCharArray();
        int m = cs1.length, n = cs2.length;
        boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j] 表示 s1[0~i]和s2[o~j]能否交织组成s3[0~i+j]
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0) dp[i][j] = dp[i - 1][j] && cs1[i - 1] == cs3[i + j - 1];
                if (j > 0) dp[i][j] |= dp[i][j - 1] && cs2[j - 1] == cs3[i + j - 1];
            }
        }
        return dp[m][n];
    }
}
