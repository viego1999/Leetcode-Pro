package offer2s;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII106
 * @since 2023/5/25 23:45
 */
public class OfferII106 {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int u, int c, int[] visited) {
        if (visited[u] != 0) { // 如果当前节点已经被染色
            return c == visited[u]; // 当前节点应该被染成 c
        }
        visited[u] = c; // 将当前节点染成 c
        for (int v : graph[u]) {
            if (!dfs(graph, v, -c, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBfs(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue; // 如果当前节点已经被染色了
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                // 将当前节点的所有邻居节点染成相反的颜色
                int u = queue.poll();
                for (int v : graph[u]) {
                    // 如果当前邻居节点已经访问过，并且节点颜色与当前颜色相同
                    if (visited[v] == visited[u]) return false;
                    if (visited[v] == 0) {
                        visited[v] = -visited[u];
                        queue.offer(v);
                    }
                }
            }
        }
        return true;
    }
}
