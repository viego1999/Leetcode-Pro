package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2596
 * @since 2023/9/13 18:59
 */
public class Problem2596 {
    public static void main(String[] args) {

    }

    public boolean checkValidGrid(int[][] grid) {
        return grid[0][0] == 0 && dfs(grid, 0, 0, 1);
    }

    public boolean dfs(int[][] grid, int i, int j, int cnt) {
        if (cnt == grid.length * grid.length) return true;
        int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] != grid[i][j] + 1) continue;
            return dfs(grid, x, y, cnt + 1);
        }
        return false;
    }
}
