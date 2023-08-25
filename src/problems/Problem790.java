package problems;

public class Problem790 {
    public static void main(String[] args) {

    }

    public int numTilings(int n) {
        int mod = (int) 1e9 + 7;
        long[][] dp = new long[n + 5][2]; // dp[i][0] - 前i列完整，未突出，dp[i][1]-前i列完整并突出一格
        dp[1][0] = 1;
        dp[1][1] = dp[2][0] = 2;
        dp[2][1] = 4;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 2][1]) % mod;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % mod;
        }
        return (int) dp[n][0];
    }

    public int numTilings_(int n) {
        int mod = (int) 1e9 + 7;
        int[] dp = new int[n + 5];
        dp[0] = 1;
        dp[1] = dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }
}
