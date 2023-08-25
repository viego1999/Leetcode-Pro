package problems;

import java.util.*;

public class Problem6243 {
    public static void main(String[] args) {
        System.out.println(minimumFuelCost(new int[][]{{0, 1}, {0, 2}, {0, 3}}, 5));
        System.out.println(minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));
        System.out.println(minimumFuelCost(new int[][]{{1, 0}, {0, 2}, {3, 1}, {1, 4}, {5, 0}}, 1));
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0 || roads[0].length == 0) return 0;
        int n = 0;
        long ans = 0;
        for (int[] road : roads) n = Math.max(road[0], road[1]) + 1;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] degrees = new int[n];
        for (int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        int[] hash = new int[n], temp = new int[n];
        for (int i = 1; i < n; i++) {
            if (degrees[i] == 1) {
                int cnt = bfs(adj, i, hash);
                ans += calculate(cnt, seats);
            } else if (degrees[i] > 2) {
                int cnt = bfs(adj, i, temp), t = calculate(cnt, seats);
                ans -= t * (degrees[i] - 2L);
            }
        }
//        for (int i = 1; i < n; i++) {
//            if (hash[i] > 2){
//                int cnt = bfs(adj, i, temp), t = calculate(cnt, seats);
//                ans -= t * (hash[i] - 2L);
//            }
//        }
        return ans;
    }

    public static int calculate(int cnt, int seats) {
        int t = 0;
        while (cnt >= seats) {
            t += seats - 1;
            cnt -= seats - 1;
            t += cnt;
            cnt -= 1;
        }
        t += cnt;
        return t;
    }

    public static int bfs(List<Integer>[] adj, int i, int[] hash) {
        int cnt = 0, f = 1;
        boolean[] vis = new boolean[adj.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        vis[i] = true;
        hash[i] += 1;
        while (!queue.isEmpty() && f == 1) {
            cnt++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                for (int next : adj[cur]) {
                    if (vis[next]) continue;
                    if (next == 0) {
                        f = 0;
                        break;
                    } else {
                        queue.offer(next);
                        hash[next] += 1;
                        vis[next] = true;
                    }
                }
            }
        }
        return cnt;
    }
}
