package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1605
 * @since 2023/3/17 0:24
 */
public class Problem1605 {
    public static void main(String[] args) {

    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] ans = new int[m][n];
        for (int i = 0, j = 0; i < m && j < n;) {
            ans[i][j] = Math.min(rowSum[i], colSum[j]);
            if (rowSum[i] < colSum[j]) colSum[j] -= rowSum[i++];
            else rowSum[i] -= colSum[j++];
        }
        return ans;
    }
}
