package problems;

public class Problem764 {
    public static void main(String[] args) {

    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] mine : mines) grid[mine[0]][mine[1]] = 1;
        int[][] left = new int[n][n], right = new int[n][n], up = new int[n][n], down = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) left[i][0] = 1;
            if (grid[i][n - 1] == 0) right[i][n - 1] = 1;
            if (grid[0][i] == 0) up[0][i] = 1;
            if (grid[n - 1][i] == 0) down[n - 1][i] = 1;
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) left[i][j] = 1 + left[i][j - 1];
                if (grid[i][n - 1 - j] == 0) right[i][n - 1 - j] = 1 + right[i][n - j];
                if (grid[j][i] == 0) up[j][i] = 1 + up[j - 1][i];
                if (grid[n - 1 - j][i] == 0) down[n - 1 - j][i] = 1 + down[n - j][i];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])));
            }
        }
        return ans;
    }

    public int orderOfLargestPlusSignBf(int n, int[][] mines) {
        int ans = 0;
        int[][] grid = new int[n][n], dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] mine : mines) grid[mine[0]][mine[1]] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int t = 1, f = 0;
                    for (int k = 1; k < n && f == 0; k++) {
                        for (int[] dir : dirs) {
                            int x = i + dir[0] * k, y = j + dir[1] * k;
                            if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == -1) {
                                f = 1;
                                break;
                            }
                        }
                        if (f == 0) t = 1 + k;
                    }
                    ans = Math.max(ans, t);
                }
            }
        }
        return ans;
    }
}
