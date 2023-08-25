package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1079
 * @since 2023/5/19 10:09
 */
public class Problem1079 {
    public static void main(String[] args) {

    }

    public int numTilePossibilities(String tiles) {
        char[] cs = tiles.toCharArray();
        Arrays.sort(cs);
        return backtrack(cs, 0, new boolean[cs.length]) - 1;
    }

    public int backtrack(char[] cs, int t, boolean[] used) {
        if (t == cs.length) return 1;
        int ans = 1;
        for (int i = 0; i < cs.length; i++) {
            if (used[i] || (i > 0 && cs[i] == cs[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            ans += backtrack(cs, t + 1, used);
            used[i] = false;
        }
        return ans;
    }
}
