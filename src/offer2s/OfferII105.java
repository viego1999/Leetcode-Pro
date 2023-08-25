package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII105
 * @since 2023/5/24 23:50
 */
public class OfferII105 {
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        return 1 + dfs(grid, x - 1, y) + dfs(grid, x, y - 1) +
                dfs(grid, x + 1, y) + dfs(grid, x, y + 1);
    }
}
