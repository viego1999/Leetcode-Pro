package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1375
 * @since 2023/6/15 14:50
 */
public class Problem1375 {
    public static void main(String[] args) {

    }

    public int numTimesAllBlue(int[] flips) {
        int ans = 0, max = 0, n = flips.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(flips[i], max);
            if (max == i + 1) ans++;
        }
        return ans;
    }
}
