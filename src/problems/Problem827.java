package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem827 {
    public static void main(String[] args) {

    }

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][] tags = new int[m][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tags[i][j] == 0) {
                    int tag = i * m + j + 7, area = dfs(grid, i, j, tags, tag);
                    map.put(tag, area);
                    ans = Math.max(ans, area);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    if (j > 0) set.add(tags[i][j - 1]);
                    if (j < n - 1)set.add(tags[i][j + 1]);
                    if (i > 0) set.add(tags[i - 1][j]);
                    if (i < m - 1) set.add(tags[i + 1][j]);
                    int tmp = 1;
                    for (Integer key : set) tmp += map.getOrDefault(key, 0);
                    ans = Math.max(ans, tmp);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j, int[][] tags, int tag) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || tags[i][j] != 0) return 0;
        tags[i][j] = tag;
        int ans = 1;
        ans += dfs(grid, i + 1, j, tags, tag);
        ans += dfs(grid, i, j + 1, tags, tag);
        ans += dfs(grid, i - 1, j, tags, tag);
        ans += dfs(grid, i, j - 1, tags, tag);
        return ans;
    }

    static class Solution { // 并查集解法
        int[] fa;

        public int largestIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length, ans = 0;
            boolean[][] vis = new boolean[m][n];
            fa = new int[m * n];
            for (int i = 0; i < m * n; i++) fa[i] = i;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !vis[i][j]) {
                        dfs(grid, i, j, i * m + j, vis);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int f = fa[i * m + j];
                        map.put(f, map.getOrDefault(f, 0) + 1);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> set = new HashSet<>();
                        if (j > 0) set.add(fa[i * m + (j - 1)]);
                        if (j < n - 1)set.add(fa[i * m + (j + 1)]);
                        if (i > 0) set.add(fa[(i - 1) * m + j]);
                        if (i < m - 1) set.add(fa[(i + 1) * m + j]);
                        int tmp = 1;
                        for (Integer key : set) tmp += map.getOrDefault(key, 0);
                        ans = Math.max(ans, tmp);
                    }
                }
            }
            return ans == 0 ? m * n : ans;
        }

        public void dfs(int[][] grid, int i, int j, int f, boolean[][] vis) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) return;
            merge(f, i * grid.length + j);
            vis[i][j] = true;
            dfs(grid, i + 1, j, f, vis);
            dfs(grid, i, j + 1, f, vis);
            dfs(grid, i - 1, j, f, vis);
            dfs(grid, i, j - 1, f, vis);
        }

        public int find(int x) {
            if (fa[x] == x) return x;
            return fa[x] = find(fa[x]);
        }

        public void merge(int i, int j) {
            fa[find(j)] = find(i);
        }
    }
}
