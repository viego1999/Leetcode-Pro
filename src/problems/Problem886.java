package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem886 {
    public static void main(String[] args) {

    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) return true;
        List<Integer>[] adjs = new ArrayList[n];
        int[] colors = new int[n]; // 0未访问，1-标记为组1，2-标记为组2
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int[] dislike : dislikes) {
            adjs[dislike[0] - 1].add(dislike[1] - 1);
            adjs[dislike[1] - 1].add(dislike[0] - 1);
        }
        for (int i = 0; i < n; i++)
            if (colors[i] == 0)
                if (!dfs(adjs, i, colors, 1)) return false;
        return true;
    }

    public boolean dfs(List<Integer>[] adjs, int root, int[] colors, int v) {
        colors[root] = v;
        for (int next : adjs[root]) {
            if (colors[next] == v) return false;
            if (colors[next] == 0 && !dfs(adjs, next, colors, 3 - v)) return false;
        }
        return true;
    }

    int[] p = new int[4010];

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    public boolean possibleBipartition_(int n, int[][] ds) {
        for (int i = 1; i <= 2 * n; i++) p[i] = i;
        for (int[] info : ds) {
            int a = info[0], b = info[1];
            if (find(a) == find(b)) return false;
            union(a, b + n);
            union(b, a + n);
        }
        return true;
    }
}
