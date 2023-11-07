package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2511
 * @since 2023/9/2 10:58
 */
public class Problem2511 {
    public static void main(String[] args) {

    }

    public int captureForts(int[] forts) {
        int l1 = -1, ln1 = -1, ans = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                if (ln1 != -1) ans = Math.max(ans, i - ln1 - 1);
                l1 = i;
                ln1 = -1;
            } else if (forts[i] == -1) {
                if (l1 != -1) ans = Math.max(ans, i - l1 - 1);
                ln1 = i;
                l1 = -1;
            }
        }
        return ans;
    }
}
