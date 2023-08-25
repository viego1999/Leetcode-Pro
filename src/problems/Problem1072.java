package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1072
 * @since 2023/5/15 12:12
 */
public class Problem1072 {
    public static void main(String[] args) {

    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[] sums = new int[m];
        for (int i = 0; i < m; i++) {
            sums[i] = Arrays.stream(matrix[i]).sum();
            if (sums[i] == 0 || sums[i] == n) ans++;
        }
        for (int i = 0; i < m; i++) {
            int[] clone = sums.clone();
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // 全部替换成1
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] == 0) clone[k]++;
                        else clone[k]--;
                    }
                }
            }
            for (int j = 0; j < m; j++) if (clone[j] == 0 || clone[j] == n) t++;
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
