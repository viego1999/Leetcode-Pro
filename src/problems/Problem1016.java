package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1016
 * @since 2023/5/11 10:07
 */
public class Problem1016 {
    public static void main(String[] args) {

    }

    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();
        char[] cs = s.toCharArray();
        for (int i = 0, m = cs.length; i < m; i++) {
            int x = cs[i] - '0';
            if (x == 0) continue;
            for (int j = i + 1; x <= n; j++) {
                set.add(x);
                if (j == m) break;
                x = (x << 1) | (cs[j] - '0');
            }
        }
        return set.size() == n;
    }

    public boolean queryStringBf(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }
}
