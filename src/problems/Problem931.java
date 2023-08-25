package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem931
 * @since 2023/7/14 0:56
 */
public class Problem931 {
    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}};
        int[][] dp = new int[n][n];
        for (int[] ints : dp) Arrays.fill(ints, 0x3f3f3f3f);
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[x][y] + matrix[i][j]);
                }
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}
