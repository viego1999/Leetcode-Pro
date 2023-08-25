package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem647
 * @since 2023/3/11 12:23
 */
public class Problem647 {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1]);
                ans += dp[j][i] ? 1 : 0;
            }
        }
        return ans;
    }

    public int countSubstrings_(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int l = i, r = i + j;
                while (l >= 0 && r < n && s.charAt(l--) == s.charAt(r++)) ans++;
            }
        }
        return ans;
    }
}
