package problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6433
 * @since 2023/5/14 10:49
 */
public class Problem6433 {
    public static void main(String[] args) {

    }

    public int maxMoves(int[][] grid) {
        int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
        int m = grid.length, n = grid[0].length, ret = 0;
        for (int i = 0; i < m; i++) {
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{i, 0});
            visited[i][0] = true;
            int step = -1;
            while (!queue.isEmpty()) {
                for (int k = queue.size(); k > 0; k--) {
                    int[] cur = queue.poll();
                    for (int[] dir : dirs) {
                        int x = cur[0] + dir[0], y = cur[1] + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] <= grid[cur[0]][cur[1]] || visited[x][y])
                            continue;
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
                step++;
            }
            ret = Math.max(ret, step);
        }
        return ret;
    }
}
