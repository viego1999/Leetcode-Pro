package problems;

import java.util.*;

public class Problem6255 {
    public static void main(String[] args) {
        System.out.println(minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
    }

    public static int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE, min = ans;
        List<int[]>[] adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int[] road : roads) {
            adjs[road[0]].add(new int[]{road[1], road[2]});
            adjs[road[1]].add(new int[]{road[0], road[2]});
            min = Math.min(min, road[2]);
        }
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] next : adjs[cur]) {
                ans = Math.min(ans, next[1]); // 先判断当前边的距离（确保每一条边都能遍历到）
                if (ans == min) return ans;
                if (vis[next[0]]) continue; // 再判断是否已经添加到队列
                queue.offer(next[0]);
                vis[next[0]] = true;
            }
        }
        return ans;
    }

    public static int minScore_(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE, min = ans;
        List<Integer>[] adjs = new ArrayList[n + 1];
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int[] road : roads) {
            long hash1 = road[0] * 131L + road[1], hash2 = road[1] * 131L + road[0];
            adjs[road[0]].add(road[1]);
            adjs[road[1]].add(road[0]);
            min = Math.min(min, road[2]);
            map.put(hash1, road[2]);
            map.put(hash2, road[2]);
        }
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = true;
        adjs[0].add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adjs[cur]) {
                if (vis[next]) continue;
                queue.offer(next);
                vis[next] = true;
                adjs[0].add(next);
            }
        }
        for (int i = 0; i < adjs[0].size(); i++) {
            for (int j = i + 1; j < adjs[0].size(); j++) {
                long hash = adjs[0].get(i) * 131L + adjs[0].get(j);
                ans = Math.min(ans, map.getOrDefault(hash, Integer.MAX_VALUE));
                if (ans == min) return ans;
            }
        }
        return ans;
    }
}
