package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII116
 * @since 2023/5/30 15:34
 */
public class OfferII116 {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, ans = 0;
        int[] fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    fa[find(fa, j)] = find(fa, i);
                }
            }
        }
        for (int i = 0; i < n; i++) if (find(fa, i) == i) ans++;
        return ans;
    }

    public int find(int[] fa, int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa, fa[x]);
    }
}
