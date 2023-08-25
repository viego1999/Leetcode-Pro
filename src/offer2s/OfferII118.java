package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII118
 * @since 2023/5/30 17:09
 */
public class OfferII118 {
    public static void main(String[] args) {

    }

    int[] fa;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        fa = new int[n];
        for (int j = 0; j < n; j++) fa[j] = j;
        for (int[] edge : edges) {
            int f1 = find(edge[1] - 1), f2 = find(edge[0] - 1);
            if (f1 != f2) fa[f1] = f2;
            else return edge;
        }
        return edges[0];
    }

    public int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
}
