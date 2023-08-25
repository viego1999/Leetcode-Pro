package offer2s;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII107
 * @since 2023/5/26 14:23
 */
public class OfferII107 {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) continue;
                mat[x][y] = mat[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{x, y});
                vis[x][y] = true;
            }
        }
        return mat;
    }
}
