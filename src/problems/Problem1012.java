package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1012
 * @since 2023/3/21 16:31
 */
public class Problem1012 {
    public static void main(String[] args) {

    }

    int[] arr = new int[10];
    int[][] dp = new int[10][1 << 10];

    public int numDupDigitsAtMostN(int n) {
        int pos = 0, x = n;
        while (x > 0) {
            arr[pos++] = x % 10;
            x /= 10;
        }
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return n - dfs(pos - 1, 0, true, true);
    }

    public int dfs(int pos, int state, boolean lead, boolean limit) {
        if (pos == -1) return lead ? 0 : 1;
        if (!limit && !lead && dp[pos][state] != -1) return dp[pos][state];
        int res = 0, up = limit ? arr[pos] : 9;
        for (int i = 0; i <= up; i++) {
            if ((!lead || i > 0)) {
                if (((state >> i) & 1) == 0)
                    res += dfs(pos - 1, state | (1 << i), false, limit && i == up);
            } else res += dfs(pos - 1, state, true, limit && i == up);
        }
        if (!limit && !lead) dp[pos][state] = res;
        return res;
    }
}
