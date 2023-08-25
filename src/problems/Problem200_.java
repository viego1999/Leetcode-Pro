package problems;

public class Problem200_ {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1'},
                {'0'},
                {'1'},
                {'0'},
                {'1'},
                {'1'},
        }));
    }

    static int[] fa, rank;

    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        fa = new int[m * n + 1];
        rank = new int[m * n + 1];
        for (int i = 0; i < fa.length; i++) fa[i] = rank[i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
                            merge(x * n + y, i * n + j);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && find(i * n + j) == i * n + j)
                    ans++;
            }
        }
        return ans;
    }

    public static int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    public static void merge(int i, int j) {
        int x = find(i), y = find(j);
        if (rank[x] <= rank[y]) fa[x] = y;
        else fa[y] = x;
        if (rank[x] == rank[y]) rank[y]++;
    }
}
