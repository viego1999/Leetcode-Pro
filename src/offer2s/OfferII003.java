package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII003
 * @since 2023/3/4 22:02
 */
public class OfferII003 {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) ans[i] = ans[i - 1] + 1;
            else ans[i] = ans[i >> 1];
        }
        return ans;
    }
}
