package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1014
 * @since 2023/4/27 11:03
 */
public class Problem1014 {
    public static void main(String[] args) {

    }

    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, n = values.length, max = values[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}
