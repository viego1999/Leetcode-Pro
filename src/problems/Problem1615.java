package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1615
 * @since 2023/3/17 0:05
 */
public class Problem1615 {
    public static void main(String[] args) {

    }

    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        boolean[][] edges = new boolean[n][n];
        for (int[] road : roads) {
            adjs[road[0]].add(road[1]);
            adjs[road[1]].add(road[0]);
            edges[road[0]][road[1]] = true;
            edges[road[1]][road[0]] = true;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = adjs[i].size() + adjs[j].size() + (edges[i][j] ? -1 : 0);
                ans = Math.max(ans, t);
            }
        }
        return ans;
    }
}
