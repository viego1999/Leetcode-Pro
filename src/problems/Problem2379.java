package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2379
 * @since 2023/3/9 0:13
 */
public class Problem2379 {
    public static void main(String[] args) {

    }

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), l = 0, r = 0, w = 0, ans = n;
        char[] cs = blocks.toCharArray();
        while (r < n) {
            if (cs[r++] == 'W') w++;
            while (r - l > k) {
                if (cs[l++] == 'W') w--;
            }
            if (r - l == k) ans = Math.min(ans, w);
        }
        return ans;
    }
}
