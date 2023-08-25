package problems;

public class Problem516 {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j > 0; j--) {
                if (cs[i - 1] == cs[j - 1]) dp[j][i] = 2 + dp[j + 1][i - 1];
                else dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
            }
        }
        return dp[1][n];
    }
}
