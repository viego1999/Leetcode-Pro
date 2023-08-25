package problems;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1377
 * @since 2023/5/24 10:35
 */
public class Problem1377 {
    public static void main(String[] args) {

    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjs[edge[0] - 1].add(edge[1] - 1);
            adjs[edge[1] - 1].add(edge[0] - 1);
        }
        boolean[] vis = new boolean[n];
        Queue<Pair<Integer, Double>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(0, 1.));
        vis[0] = true;
        while (!queue.isEmpty() && t >= 0) {
            for (int i = queue.size(); i > 0; i--) {
                Pair<Integer, Double> curr = queue.poll();
                int cnt = adjs[curr.getKey()].size() - (curr.getKey() == 0 ? 0 : 1);
                if (curr.getKey() == target - 1) return t * cnt == 0 ? curr.getValue() : 0.;
                double prob = cnt > 0 ? (curr.getValue() / cnt) : 0.;
                for (int next : adjs[curr.getKey()]) {
                    if (!vis[next]) {
                        queue.offer(new Pair<>(next, prob));
                        vis[next] = true;
                    }
                }
            }
            t--;
        }
        return 0.;
    }
}
