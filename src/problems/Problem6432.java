package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6432
 * @since 2023/5/14 11:03
 */
public class Problem6432 {
    public static void main(String[] args) {

    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adjs = new ArrayList[n];
        Set<Set<Integer>> sets = new HashSet<>();
        Set<Long> es = new HashSet<>();
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
            es.add(edge[0] * 55L + edge[1]);
            es.add(edge[1] * 55L + edge[0]);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Set<Integer> set = new HashSet<>();
                dfs(adjs, i, vis, set);
                sets.add(set);
            }
        }
        int ret = sets.size();
        for (Set<Integer> set : sets) {
            List<Integer> nodes = new ArrayList<>(set);
            boolean flag = true;
            for (int i = 0; i < nodes.size() && flag; i++) {
                for (int j = i + 1; j < nodes.size(); j++) {
                    if (!es.contains(nodes.get(i) * 55L + nodes.get(j))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) ret--;
        }
        return ret;
    }

    public void dfs(List<Integer>[] adjs, int curr, boolean[] vis, Set<Integer> set) {
        set.add(curr);
        vis[curr] = true;
        for (int next : adjs[curr]) {
            if (vis[next]) continue;
            dfs(adjs, next, vis, set);
        }
    }
}
