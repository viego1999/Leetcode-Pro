package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1254
 * @since 2023/6/18 16:36
 */
public class Problem1254 {
    public static void main(String[] args) {

    }

    boolean flag = true;

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    flag = true;
                    dfs(grid, i, j);
                    if (flag) ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int x, int y) {
        grid[x][y] = -1;
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) flag = false;
        for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
            int i = x + dir[0], j = y + dir[1];
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) continue;
            dfs(grid, i, j);
        }
    }
}
