package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1335
 * @since 2023/5/16 13:24
 */
public class Problem1335 {
    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[]{6,5,4,3,2,1}, 2));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n + 1][d + 1];
        for (int[] ints : dp) Arrays.fill(ints, 0x3f3f3f3f);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= d; j++) {
                int max = 0;
                for (int k = i; k >= j; k--) {
                    max = Math.max(max, jobDifficulty[k - 1]);
                    dp[i][j] = Math.min(dp[i][j], max + dp[k - 1][j - 1]);
                }
            }
        }
        return dp[n][d];
    }
}
