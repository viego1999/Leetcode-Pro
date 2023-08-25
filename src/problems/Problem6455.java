package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6455
 * @since 2023/5/28 12:10
 */
public class Problem6455 {
    public static void main(String[] args) {

    }

    public long minimumCost(String s) {
        long ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += Math.min(i, s.length() - i);
            }
        }
        return ans;
    }
}
