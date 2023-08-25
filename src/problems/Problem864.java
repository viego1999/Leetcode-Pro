package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Problem864 {
    public static void main(String[] args) {
        System.out.println(shortestPathAllKeys(new String[]{
                "@...a",
                ".###A",
                "b.BCc"
        }));
    }

    public static int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length(), num = 0;
        char[][] mat = new char[m][n];
        int[][][] dp = new int[m][n][1 << 6];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            mat[i] = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                if (mat[i][j] == '@') {
                    queue.offer(new int[]{i, j, 0});
                    dp[i][j][0] = 0; // 起点
                } else if (mat[i][j] >= 'a' && mat[i][j] <= 'f') num++;
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], state = cur[2], step = dp[i][j][state];
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || mat[x][y] == '#') continue;
                if (mat[x][y] >= 'A' && mat[x][y] <= 'F' && (state >> (mat[x][y] - 'A') & 1) == 0) continue;
                int nstate = state;
                if (mat[x][y] >= 'a' && mat[x][y] <= 'f') nstate |= 1 << (mat[x][y] - 'a');
                if (nstate == (1 << num) - 1) return step + 1;
                if (step + 1 >= dp[x][y][nstate]) continue;
                dp[x][y][nstate] = step + 1;
                queue.offer(new int[]{x, y, nstate});
            }
        }
        return -1;
    }
}
