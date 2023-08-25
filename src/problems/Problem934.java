package problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem934 {
    public static void main(String[] args) {

    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] tags;
    boolean[][] vis;
    int n, ans = 0;

    public int shortestBridge(int[][] grid) {
        n = grid[0].length;
        tags = new int[n][n];
        boolean flag = true; // 是否继续
        // 将第一座岛屿标记为-1
        for (int i = 0; i < n && flag; i++) {
            for (int j = 0; j < n && flag; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    flag = false;
                }
            }
        }
        vis = new boolean[n][n];
        // 找到第一座岛屿所有周围为0的地区
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
                            queue.offer(new int[]{x, y});
                            vis[i][j] = true;
                        }
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < n && y < n && !vis[x][y]) {
                        if (grid[x][y] == 1) return ans;
                        if (grid[x][y] == 0) {
                            queue.offer(new int[]{x, y});
                            vis[x][y] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return;
        grid[i][j] = -1;
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
