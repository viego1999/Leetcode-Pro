package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1653
 * @since 2023/3/6 16:38
 */
public class Problem1653 {
    public static void main(String[] args) {

    }

    public int minimumDeletionsDp(String s) {
        int b = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') b++;
            else ans = Math.min(ans + 1, b);
        }
        return ans;
    }

    public int minimumDeletions(String s) {
        int n = s.length(), ans;
        int[] cnta = new int[n + 1], cntb = new int[n + 1];
        char[] cs = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            if (cs[i - 1] == 'a') {
                cnta[i] = cnta[i - 1] + 1;
                cntb[i] = cntb[i - 1];
            } else {
                cntb[i] = cntb[i - 1] + 1;
                cnta[i] = cnta[i - 1];
            }
        }
        ans = cnta[n];
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, cntb[i] + cnta[n] - cnta[i]);
        }
        return ans;
    }
}
