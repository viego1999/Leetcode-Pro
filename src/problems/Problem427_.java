package problems;

import util.FNode;

public class Problem427_ {
    public static void main(String[] args) {

    }

    public FNode construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid[0].length);
    }

    public FNode dfs(int[][] grid, int x1, int y1, int x2, int y2) {
        boolean isLeaf = true;
        for (int i = x1; i < x2 && isLeaf; i++) {
            for (int j = y1; j < y2 && isLeaf; j++) {
                if (grid[i][j] != grid[x1][y1]) isLeaf = false;
            }
        }
        if (isLeaf) return new FNode(grid[x1][y1] == 1, true);
        FNode node = new FNode(true, false);
        node.topLeft = dfs(grid, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
        node.topRight = dfs(grid, x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
        node.bottomLeft = dfs(grid, (x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
        node.bottomRight = dfs(grid, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
        return node;
    }
}
