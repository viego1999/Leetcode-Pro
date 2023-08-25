package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6313
 * @since 2023/3/4 23:36
 */
public class Problem6313 {
    public static void main(String[] args) {

    }

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        int n = ranges.length, cnt = 0;
        for (int i = 0, j = -1; i < n; i++) {
            if (ranges[i][0] > j) cnt++;
            j = Math.max(j, ranges[i][1]);
        }
        return (int) quickMi(2, cnt);
    }

    public long quickMi(long a, long b) {
        int mod = (int) 1e9 + 7;
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
