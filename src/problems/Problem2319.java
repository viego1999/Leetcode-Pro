package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2319
 * @since 2023/1/31 10:49
 */
public class Problem2319 {

    public static void main(String[] args) {

    }

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0, n = grid.length; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == n - i - 1) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}
