package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6456
 * @since 2023/5/28 11:51
 */
public class Problem6456 {
    public static void main(String[] args) {

    }

    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length, ans = 0;
        int[][] dp = new int[m][n];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(mat, i, j, dp));
            }
        }
        return ans;
    }

    public int dfs(int[][] mat, int r, int c, int[][] dp) {
        if (dp[r][c] != -1) return dp[r][c];
        int ans = 1;
         for (int i = 0; i < mat.length; i++) {
             if (i != r && mat[i][c] > mat[r][c]) ans = Math.max(ans, dfs(mat, i, c, dp) + 1);
         }
         for (int j = 0; j < mat[0].length; j++) {
             if (j != c && mat[r][j] > mat[r][c]) ans = Math.max(ans, dfs(mat, r, j, dp) + 1);
         }
        return dp[r][c] = ans;
    }

    static class Solution {
        Integer[][] rows, cols;
        int[][] mat;

        public int maxIncreasingCells(int[][] mat) {
            this.mat = mat;
            int m = mat.length, n = mat[0].length, ans = 0;
            int[][] dp = new int[m][n];
            for (int[] ints : dp) Arrays.fill(ints, -1);
            rows = new Integer[m][n];
            cols = new Integer[n][m];
            for (int i = 0; i < m; i++) {
                int[] temp = mat[i].clone();
                for (int j = 0; j < n; j++) {
                    rows[i][j] = j;
                }
                Arrays.sort(rows[i], (x, y) -> temp[x] - temp[y]);
            }
            for (int i = 0; i < n; i++) {
                int[] temp = new int[m];
                for (int j = 0; j < m; j++) {
                    cols[i][j] = j;
                    temp[j] = mat[j][i];
                }
                Arrays.sort(cols[i], (x, y) -> temp[x] - temp[y]);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, dfs(mat, i, j, dp));
                }
            }
            return ans;
        }

        public int dfs(int[][] mat, int r, int c, int[][] dp) {
            if (dp[r][c] != -1) return dp[r][c];
            int ans = 1;
            for (int i = binarySearch(0, c, mat[r][c]); i < mat.length; i++) {
                if (mat[cols[c][i]][c] > mat[r][c]) ans = Math.max(ans, dfs(mat, cols[c][i], c, dp) + 1);
                else break;
            }
            for (int j = binarySearch(1, r, mat[r][c]); j < mat[0].length; j++) {
                if (mat[r][rows[r][j]] > mat[r][c]) ans = Math.max(ans, dfs(mat, r, rows[r][j], dp) + 1);
                else break;
            }
            return dp[r][c] = ans;
        }

        public int binarySearch(int flag, int idx, int t) {
            if (flag == 1) {
                Integer[] temp = rows[idx];
                int l = 0, r = temp.length - 1;
                while (l < r) {
                    int m = l + r >> 1;
                    if (mat[idx][temp[m]] > t) r = m;
                    else l = m + 1;
                }
                return l;
            } else {
                Integer[] temp = cols[idx];
                int l = 0, r = temp.length - 1;
                while (l < r) {
                    int m = l + r >> 1;
                    if (mat[temp[m]][idx] > t) r = m;
                    else l = m + 1;
                }
                return l;
            }
        }
    }
}
