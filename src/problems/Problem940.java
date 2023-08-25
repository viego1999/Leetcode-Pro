package problems;

public class Problem940 {
    public static void main(String[] args) {

    }

    public int distinctSubseqII(String s) {
        int n = s.length(), mod = (int) 1e9 + 7, ans = 0;
        int[][] dp = new int[n + 1][26]; // dp[i][j]表示第i位以字符j结尾拥有的数量
        for (int i = 1; i <= n; i++) {
            int cs = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (cs != j) dp[i][j] = dp[i - 1][j];
                else {
                    int t = 1;
                    for (int k = 0; k < 26; k++) t = (t + dp[i - 1][k]) % mod;
                    dp[i][j] = t;
                }
            }
        }
        for (int i = 0; i < 26; i++) ans = (ans + dp[n][i]) % mod;
        return ans;
    }
}
