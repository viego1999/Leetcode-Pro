package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1044
 * @since 2023/10/21 18:27
 */
public class Problem1044 {
    public static void main(String[] args) {

    }

    long[] h, p;

    public String longestDupSubstring(String s) {
        int n = s.length(), l = 0, r = n, P = 13131;
        String ans = "";
        h = new long[n + 1];
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);
        }
        while (l < r) {
            int m = l + r + 1 >> 1;
            String t = check(s, m);
            if (t.length() != 0) l = m;
            else r = m - 1;
            ans = t.length() > ans.length() ? t : ans;
        }
        return ans;
    }

    public String check(String s, int len) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= s.length(); i++) {
            int j = i + len - 1;
            long hh = h[j] - h[i - 1] * p[j - i + 1];
            if (!set.add(hh)) return s.substring(i - 1, j);
        }
        return "";
    }
}
