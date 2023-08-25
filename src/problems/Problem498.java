package problems;

import java.util.Arrays;

/**
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 *
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 *
 * link: https://leetcode.cn/problems/diagonal-traverse/
 */
public class Problem498 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        })));

        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                {2, 5},
                {8, 4},
                {0, -1}
        })));
    }

    // [1,2,4,7,5,3,6,8,9]
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, k = 0;
        int[] ans = new int[m * n];
        for (int t = 0; t < n; t++) { // 遍历第一行
            if ((t & 1) == 1) {
                for (int i = 0, j = t; i < m && j >= 0; i++, j--) {
                    ans[k++] = mat[i][j];
                }
            } else {
                int c = Math.min(t, m - 1); // 2, 1
                for (int i = c, j = t - c; i >= 0 && j < n; i--, j++) {
                    ans[k++] = mat[i][j];
                }
            }
        }
        for (int t = 1; t < m; t++) { // 遍历最后一列
            if (((t + n - 1) & 1) == 1) {
                for (int i = t, j = n - 1; i < m && j >= 0; i++, j--) {
                    ans[k++] = mat[i][j];
                }
            } else {
                int c = Math.min(n - 1, m - t - 1);
                for (int i = t + c, j = n - c - 1; i >= 0 && j < n; i--, j++) {
                    ans[k++] = mat[i][j];
                }
            }
        }
        return ans;
    }
}
