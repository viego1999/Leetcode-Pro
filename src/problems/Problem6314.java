package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6314
 * @since 2023/3/4 23:31
 */
public class Problem6314 {
    public static void main(String[] args) {

    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = 0, ans = 0;
        Set<Long> set = new HashSet<>();
        for (int[] guess : guesses) set.add(guess[0] * (long) 1e5 + guess[1]);
        for (int[] edge : edges) n = Math.max(n, Math.max(edge[0], edge[1]));
        List<Integer>[] adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }
        for (int i = 0; i <= n; i++) {
            int cnt = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            boolean[] vis = new boolean[n + 1];
            vis[i] = true;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : adjs[curr]) {
                    if (vis[next]) continue;
                    long hash = curr * (long) 1e5 + next;
                    if (set.contains(hash)) cnt++;
                    vis[next] = true;
                    queue.offer(next);
                }
            }
            if (cnt >= k) ans++;
        }
        return ans;
    }
}
