package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2712
 * @since 2023/8/20 0:19
 */
public class Problem2712 {
    public static void main(String[] args) {

    }

    public long minimumCost(String s) {
        long ans = 0;
        char[] cs = s.toCharArray();
        for (int i = 1, n = cs.length; i < n; i++) {
            if (cs[i] != cs[i - 1]) ans += Math.min(i, n - i);
        }
        return ans;
    }
}
