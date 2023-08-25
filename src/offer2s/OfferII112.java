package offer2s;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII112
 * @since 2023/5/26 23:06
 */
public class OfferII112 {
    public static void main(String[] args) {

    }

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }

    public int dfs(int[][] mat, int r, int c, int[][] dp) {
        if (dp[r][c] != -1) return dp[r][c];
        int ans = 1, m = mat.length, n = mat[0].length;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int x = r + dir[0], y = c + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || mat[r][c] <= mat[x][y]) continue;
            ans = Math.max(ans, dfs(mat, x, y, dp) + 1);
        }
        return dp[r][c] = ans;
    }
}
