package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1129
 * @since 2023/2/2 9:08
 */
public class Problem1129 {

    public static void main(String[] args) {

    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer>[][] adjs = new ArrayList[2][n];
        for (int i = 0; i < n; i++) {
            adjs[0][i] = new ArrayList<>();
            adjs[1][i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) adjs[0][edge[0]].add(edge[1]);
        for (int[] edge : blueEdges) adjs[1][edge[0]].add(edge[1]);
        int dis = 0;
        boolean[][] vis = new boolean[2][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int curr = poll[0], flag = poll[1];
                if (ans[curr] == -1) ans[curr] = dis;
                vis[flag][curr] = true;
                flag ^= 1;
                for (int next : adjs[flag][curr]) {
                    if (!vis[flag][next]) {
                        queue.offer(new int[]{next, flag});
                    }
                }
            }
            dis++;
        }
        return ans;
    }

    public int[] shortestAlternatingPaths_(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] ans = new int[2][n];
        Arrays.fill(ans[0], 0x3f3f3f3f);
        Arrays.fill(ans[1], 0x3f3f3f3f);
        List<Integer>[][] adjs = new ArrayList[2][n];
        for (int i = 0; i < n; i++) {
            adjs[0][i] = new ArrayList<>();
            adjs[1][i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) adjs[0][edge[0]].add(edge[1]);
        for (int[] edge : blueEdges) adjs[1][edge[0]].add(edge[1]);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0}); // 0表示走红边
        queue.offer(new int[]{0, 1}); // 1表示走蓝边
        int dis = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, s = queue.size(); i < s; i++) {
                int[] poll = queue.poll();
                int curr = poll[0], flag = poll[1];
                ans[flag][curr] = dis;
                flag ^= 1;
                for (int next : adjs[flag][curr]) {
                    if (dis < ans[flag][next]) {
                        queue.offer(new int[]{next, flag});
                        ans[flag][next] = dis;
                    }
                }
            }
            dis++;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = Math.min(ans[0][i], ans[1][i]);
            ans[0][i] = ans[0][i] == 0x3f3f3f3f ? -1 : ans[0][i];
        }
        return ans[0];
    }
}
