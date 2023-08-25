package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII020
 * @since 2023/4/6 19:58
 */
public class OfferII020 {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int l = i, r = i + j;
                while (l >= 0 && r < n && cs[l--] == cs[r++]) ans++;
            }
        }
        return ans;
    }
}
