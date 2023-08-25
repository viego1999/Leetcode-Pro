package problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1091
 * @since 2023/5/26 10:28
 */
public class Problem1091 {
    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int ans = 1, n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        if (grid[0][0] == 0) queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) return ans;
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || vis[x][y]) continue;
                    queue.offer(new int[]{x, y});
                    vis[x][y] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
