package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1637
 * @since 2023/3/30 8:36
 */
public class Problem1637 {
    public static void main(String[] args) {

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x, y) -> x[0] - y[0]);
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
