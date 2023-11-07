package problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1921
 * @since 2023/9/4 10:39
 */
public class Problem1921 {
    public static void main(String[] args) {
        // 3/7
        // (3 + 7 - 1) / 7
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length, ans = 0;
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) array[i] = new int[]{dist[i], speed[i]};
        Arrays.sort(array, Comparator.comparingDouble(x -> (double) x[0] / x[1]));
        for (int i = 0; i < n; i++) {
            if (array[i][0] - array[i][1] * i > 0) ans++;
            else break;
        }
        return ans;
    }
}
