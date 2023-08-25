package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1326
 * @since 2023/2/21 14:40
 */
public class Problem1326 {
    public static void main(String[] args) {

    }

    public int minTaps(int n, int[] ranges) {
        int[][] array = new int[n + 1][2];
        for (int i = 0; i <= n; i++) array[i] = new int[]{i - ranges[i], i + ranges[i]};
        Arrays.sort(array, (x, y) -> x[0] - y[0]);
        for (int i = 0, j = 0, ans = 0; i <= n; ans++) { // j为上一次的覆盖最远点
            int k = i, l = 0; // l为下一次的能覆盖的最远距离
            while (k <= n && array[k][0] <= j) l = Math.max(l, array[k++][1]);
            if (k == i) return -1;
            i = k;
            if ((j = l) >= n) return ++ans;
        }
        return -1;
    }
}
