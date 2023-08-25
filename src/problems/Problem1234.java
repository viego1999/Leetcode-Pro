package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1234
 * @since 2023/2/13 9:55
 */
public class Problem1234 {
    public static void main(String[] args) {
        // WWEQERQ WQWW RWWERQWEQ
        // WWEQERQ EQRR RWWERQWEQ
        System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));
        System.out.println(balancedString(new StringBuilder("WWEQERQWQWWRWWERQWEQ").reverse().toString()));
    }

    public static int balancedString(String s) {
        char[] cs = s.toCharArray();
        int[] cnts = new int['Z'];
        for (char c : cs) ++cnts[c];
        int n = cs.length, c = n / 4, l = 0, r = 0, ans = n;
        if (cnts['Q'] == c && cnts['W'] == c && cnts['E'] == c && cnts['R'] == c) return 0;
        while (r < n) {
            cnts[cs[r]]--;
            // 窗口外每种字符的数目小于等于平均值即可
            while (cnts['Q'] <= c && cnts['W'] <= c && cnts['E'] <= c && cnts['R'] <= c) {
                ans = Math.min(ans, r - l + 1);
                ++cnts[cs[l++]];
            }
            r++;
        }
        return ans;
    }
}
