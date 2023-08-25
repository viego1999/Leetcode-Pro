package problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1263
 * @since 2023/5/9 0:11
 */
public class Problem1263 {
    public static void main(String[] args) {

    }

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][][][] vis = new boolean[m][n][m][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // down, up, left, right
        int ans = 0, sx = 0, sy = 0, bx = 0, by = 0, tx = 0, ty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{bx, by, sx, sy});
        vis[bx][by][sx][sy] = true;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curr = queue.poll();
                if (curr[0] == tx && curr[1] == ty) return ans;
                for (int[] dir : dirs) {
                    int newBx = curr[0] + dir[0], newBy = curr[1] + dir[1];
                    int newSx = curr[0] - dir[0], newSy = curr[1] - dir[1];
                    if (newBx < 0 || newBx >= m || newBy < 0 || newBy >= n || grid[newBx][newBy] == '#') continue;
                    if (newSx < 0 || newSx >= m || newSy < 0 || newSy >= n || grid[newSx][newSy] == '#') continue;
                    if (vis[newBx][newBy][curr[0]][curr[1]]) continue;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{curr[2], curr[3]});
                    boolean[][] used = new boolean[m][n];
                    boolean flag = false;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        if (now[0] == newSx && now[1] == newSy) {
                            flag = true;
                            break;
                        }
                        for (int[] d : dirs) {
                            int x = now[0] + d[0], y = now[1] + d[1];
                            if (x < 0 || x >= m || y < 0 || y >= n || (x == curr[0] && y == curr[1]) || grid[x][y] == '#' || used[x][y])
                                continue;
                            q.offer(new int[]{x, y});
                            used[x][y] = true;
                        }
                    }
                    if (flag) {
                        queue.offer(new int[]{newBx, newBy, curr[0], curr[1]});
                        vis[newBx][newBy][curr[0]][curr[1]] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
