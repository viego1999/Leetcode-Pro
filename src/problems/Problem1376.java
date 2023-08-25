package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1376
 * @since 2023/5/1 13:04
 */
public class Problem1376 {
    public static void main(String[] args) {

    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) adjs[manager[i]].add(i);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        queue.offer(new int[]{headID, 0});
        vis[headID] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curr = queue.poll();
                for (int next : adjs[curr[0]]) {
                    if (!vis[next]) {
                        int time = informTime[curr[0]] + curr[1];
                        ans = Math.max(ans, time);
                        queue.offer(new int[]{next, time});
                        vis[next] = true;
                    }
                }
            }
        }
        return ans;
    }
}
