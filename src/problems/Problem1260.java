package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *
 * link: https://leetcode.cn/problems/shift-2d-grid/
 */
public class Problem1260 {

    public static void main(String[] args) {
        System.out.println(shiftGrid(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 1));

        System.out.println(shiftGrid(new int[][]{
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13}
        }, 4));

        System.out.println(shiftGrid(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 9));

        System.out.println(shiftGrid(new int[][]{
                {1},
                {2},
                {3},
                {4},
                {7},
                {6},
                {5},
        }, 23));
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, c = m * n;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) list.add(0);
            ans.add(list);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = (i * n + j + k) % c;
                ans.get(t / n).set(t % n, grid[i][j]);
            }
        }
        return ans;
    }

    public static List<List<Integer>> shiftGrid1D(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, t = m * n, c = 0;
        k %= t;
        int[] arr = new int[t];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i * n + j);
                arr[c++] = grid[i][j];
            }
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = t - k; i < t; i++) {
            list.add(arr[i]);
            if (list.size() == n) {
                ans.add(new ArrayList<>(list));
                list.clear();
            }
        }
        for (int i = 0; i < t - k; i++) {
            list.add(arr[i]);
            if (list.size() == n) {
                ans.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return ans;
    }

    public static List<List<Integer>> shiftGrid2D(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, t = m * n;
        k %= t;
        int r = (k - 1) / n, c = (k - 1) % n, sr = (m - r - 1) % m, sc = (n - c - 1) % n;
        if (k == 0) sr = sc = 0;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = sc; j < n; j++) {
            list.add(grid[sr][j]);
            if (list.size() == n) {
                ans.add(new ArrayList<>(list));
                list.clear();
            }
        }
        for (int i = sr + 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
                if (list.size() == n) {
                    ans.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
                if (list.size() == n) {
                    ans.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        for (int j = 0; j < sc; j++) {
            list.add(grid[sr][j]);
            if (list.size() == n) {
                ans.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return ans;
    }
}
