package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2399
 * @since 2023/4/9 17:26
 */
public class Problem2399 {
    public static void main(String[] args) {

    }

    public boolean checkDistances(String s, int[] distance) {
        int[] ans = new int[26];
        Arrays.fill(ans, -1);
        char[] cs = s.toCharArray();
        for (int i = 0, n = cs.length; i < n; i++) {
            int idx = cs[i] - 'a';
            if (ans[idx] == -1) ans[idx] = i;
            else if (i - ans[idx] - 1 != distance[idx]) return false;
        }
        return true;
    }
}
