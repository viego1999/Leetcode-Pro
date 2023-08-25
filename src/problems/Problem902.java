package problems;

import java.util.Arrays;

public class Problem902 {
    public static void main(String[] args) {

    }

    int[][] dp = new int[10][2];
    int[] arr = new int[10];
    boolean[] hash = new boolean[10];

    public int atMostNGivenDigitSet(String[] digits, int n) {
        for (String digit : digits) hash[Integer.parseInt(digit)] = true;
        for (int[] ints : dp) Arrays.fill(ints, -1);
        int pos = 0;
        while (n != 0) {
            arr[pos++] = n % 10;
            n /= 10;
        }
        return dfs(pos - 1, 1, true, true);
    }

    public int dfs(int pos, int pre, boolean lead, boolean limit) {
        if (pos == -1) return lead ? 0 : 1; // 如果全为0则返回0，否则该数字合法返回1
        if (!limit && !lead && dp[pos][pre] != -1) return dp[pos][pre];
        int res = 0, up = limit ? arr[pos] : 9;
        for (int i = 0; i <= up; i++) {
            if (hash[i] || (i == 0 && lead))
                res += dfs(pos - 1, pre, lead && i == 0, limit && i == up);
        }
        if (!limit && !lead) dp[pos][pre] = res;
        return res;
    }
}
