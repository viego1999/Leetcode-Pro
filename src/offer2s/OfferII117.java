package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII117
 * @since 2023/5/30 16:10
 */
public class OfferII117 {
    public static void main(String[] args) {

    }

    int[] fa;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length, ans = 0;
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char[] cs1 = strs[i].toCharArray(), cs2 = strs[j].toCharArray();
                int diff = 0;
                for (int k = 0; k < cs1.length; k++) {
                    if (cs1[k] != cs2[k]) if (++diff > 2) break;
                }
                if (diff <= 2) fa[find(j)] = find(i);
            }
        }
        for (int i = 0; i < n; i++) if (i == find(i)) ans++;
        return ans;
    }

    public int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
}
