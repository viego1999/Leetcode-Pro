package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII019
 * @since 2023/4/6 19:45
 */
public class OfferII019 {
    public static void main(String[] args) {

    }

    public boolean validPalindrome(String s) {
        int n = s.length(), l1 = 0, l2 = 0, r1 = n - 1, r2 = r1, t1 = 0, t2 = 0, f1 = 1, f2 = 1;
        char[] cs = s.toCharArray();
        while (l1 < r1 && f1 > 0) {
            if (cs[l1++] != cs[r1--]) {
                if (++t1 > 1) f1 = 0;
                r1++;
            }
        }
        while (l2 < r2 && f2 > 0) {
            if (cs[l2++] != cs[r2--]) {
                if (++t2 > 1) f2 = 0;
                l2--;
            }
        }
        return f1 > 0 || f2 > 0;
    }
}
