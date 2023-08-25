package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6440
 * @since 2023/5/21 11:16
 */
public class Problem6440 {
    public static void main(String[] args) {
        System.out.println(makeSmallestPalindrome("abea"));
    }

    public static String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, l = 0, r = n - 1;
        while (l < r) {
            cs[l] = cs[r] = (char) (Math.min(cs[l++], cs[r--]));
        }
        return new String(cs);
    }
}
