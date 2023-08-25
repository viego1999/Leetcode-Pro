package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2500
 * @since 2023/7/27 23:42
 */
public class Problem2500 {
    public static void main(String[] args) {

    }

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) Arrays.sort(ints);
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
