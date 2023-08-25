package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1223
 * @since 2023/2/10 10:50
 */
public class Problem1223 {
    public static void main(String[] args) {

    }

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n][7][16];
        for (int[][] ints : dp) for (int[] ints2 : ints) Arrays.fill(ints2, -1);
        return dfs(dp, rollMax, n - 1, 0, 0);
    }

    public int dfs(int[][][] dp, int[] rollMax, int pos, int pre, int cnt) {
        if (pos == -1) return 1;
        if (dp[pos][pre][cnt] != -1) return dp[pos][pre][cnt];
        long res = 0;
        for (int i = 1; i <= 6; i++) {
            if (pre != i) res += dfs(dp, rollMax, pos - 1, i, 1);
            else if (cnt < rollMax[i - 1]) res += dfs(dp, rollMax, pos - 1, i, cnt + 1);
        }
        return dp[pos][pre][cnt] = (int) (res % (1e9 + 7));
    }
}
