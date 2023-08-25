package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6403
 * @since 2023/4/29 22:42
 */
public class Problem6403 {
    public static void main(String[] args) {

    }

    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(grid, i, j, new boolean[m][n]));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) return 0;
        int ans = grid[i][j];
        vis[i][j] = true;
        ans += dfs(grid, i + 1, j, vis);
        ans += dfs(grid, i, j + 1, vis);
        ans += dfs(grid, i - 1, j, vis);
        ans += dfs(grid, i, j - 1, vis);
        return ans;
    }
}
