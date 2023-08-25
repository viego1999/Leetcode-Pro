package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1971 {
    public static void main(String[] args) {

    }

    int[] fa;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int[] edge : edges) {
            fa[find(edge[1])] = find(edge[0]);
        }
        return find(source) == find(destination);
    }

    public int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    public boolean validPathDfs(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(adjs, source, destination, vis);
    }

    public boolean dfs(List<Integer>[] adjs, int curr, int target, boolean[] vis) {
        if (curr == target) return true;
        vis[curr] = true;
        for (int next : adjs[curr]) {
            if (!vis[next] && dfs(adjs, next, target, vis)) return true;
        }
        return false;
    }
}
