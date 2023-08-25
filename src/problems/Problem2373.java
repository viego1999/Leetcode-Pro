package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2373
 * @since 2023/3/1 0:06
 */
public class Problem2373 {
    public static void main(String[] args) {

    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        ans[i][j] = Math.max(ans[i][j], grid[k][l]);
                    }
                }
            }
        }
        return ans;
    }
}
