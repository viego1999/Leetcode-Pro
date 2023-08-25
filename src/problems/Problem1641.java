package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1641
 * @since 2023/3/29 11:03
 */
public class Problem1641 {
    public static void main(String[] args) {

    }

    public int countVowelStringsDpOpt(int n) {
        int[]  dp = new int[5]; // 长度为i以j开头
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) ans += dp[i];
        return ans;
    }

    public int countVowelStringsDp(int n) {
        int[][]  dp = new int[n][5]; // 长度为i以j开头
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j; k < 5; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) ans += dp[n - 1][i];
        return ans;
    }

    int[][] dp;

    public int countVowelStrings(int n) {
        dp = new int[n][5];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(n - 1, 0);
    }

    public int dfs(int pos, int pre) {
        if (pos == -1) return 1;
        if (dp[pos][pre] != -1) return dp[pos][pre];
        int res = 0;
        for (int i = pre; i < 5; i++) {
            res += dfs(pos - 1, i);
        }
        return dp[pos][pre] = res;
    }
}
