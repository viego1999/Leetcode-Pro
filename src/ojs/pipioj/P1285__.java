package ojs.pipioj;

import java.util.*;

public class P1285__ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        List<Integer>[] adjacency = new ArrayList[n];
        for (int i = 0; i < n; i++) adjacency[i] = new ArrayList<>();
        while (m-- > 0) {
            int x = scan.nextInt(), y = scan.nextInt();
            adjacency[x - 1].add(y - 1);
        }
        System.out.println(unionFind(adjacency) ? "yes" : "no");
    }

    static int[] fa;

    public static boolean unionFind(List<Integer>[] adj) {
        int n = adj.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int u = 0; u < n; u++) {
            for (int v : adj[u]) {
                if (fa[u] == v) return true;
                merge(v, u);
            }
        }
        return false;
    }

    /**
     * 寻找 x 的领队节点，当不为自己时，重新将 x 的父节点指向 x 父节点的领队节点
     *
     * @param x x
     * @return 返回 x 的领队节点
     */
    private static int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    /**
     * 将 x 的领队节点的父指向（并入） y 的领队节点 中，即
     *
     * @param x x
     * @param y y
     */
    private static void merge(int x, int y) {
        fa[find(x)] = find(y);
    }
}
