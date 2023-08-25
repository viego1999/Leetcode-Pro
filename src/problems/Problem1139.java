package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1139
 * @since 2023/2/17 9:52
 */
public class Problem1139 {
    public static void main(String[] args) {

    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][] rights = new int[m][n], bottoms = new int[m][n];
        for (int i = 0; i < m; i++) rights[i][n - 1] = grid[i][n - 1];
        for (int j = 0; j < n; j++) bottoms[m - 1][j] = grid[m - 1][j];
        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                rights[i][j] = grid[i][j] + (grid[i][j] == 0 ? 0 : rights[i][j + 1]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = m - 2; i >= 0; i--) {
                bottoms[i][j] = grid[i][j] + (grid[i][j] == 0 ? 0 : bottoms[i + 1][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(rights[i][j], bottoms[i][j]);
                for (int k = min; k > ans; k--) {
                    if (rights[i + k - 1][j] < k || bottoms[i][j + k - 1] < k) continue;
                    ans = k;
                }
            }
        }
        return ans * ans;
    }
}
