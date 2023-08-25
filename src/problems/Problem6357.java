package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6357
 * @since 2023/2/13 11:38
 */
public class Problem6357 {
    public static void main(String[] args) {

    }

    // abacaba
    // bzaa
    public int minimumScore(String s, String t) {
        int m = s.length(), n = t.length(), ans = n;
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        int[] prefix = new int[m + 1], suffix = new int[m + 1];
        prefix[0] = -1;
        for (int i = 1, j = 0; i <= m; i++) {
            if (j < n && ss[i - 1] == ts[j]) j++;
            prefix[i] = j - 1;
        }
        suffix[m] = n;
        for (int i = m - 1, j = n - 1; i >= 0; i--) {
            if (j >= 0 && ss[i] == ts[j]) j--;
            suffix[i] = j + 1;
        }
        for (int i = 0; i <= m; i++) {
            int cur = Math.max(0, suffix[i] - prefix[i] - 1);
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
