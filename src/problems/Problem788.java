package problems;

import java.util.Arrays;

public class Problem788 {
    public static void main(String[] args) {

    }

    int[] arr = new int[6];
    int[][] dp = new int[6][2]; // dp[i][j]表示当前数字位数为i时，前面是否出现过不同数翻转

    public int rotatedDigits(int n) {
        for (int i = 0; i < 6; i++) Arrays.fill(dp[i], -1);
        int pos = 0;
        while (n != 0) {
            arr[pos++] = n % 10;
            n /= 10;
        }
        return dfs(pos - 1, 0, true);
    }

    public int dfs(int pos, int flag, boolean limit) {
        if (pos < 0) return flag;
        if (dp[pos][flag] != -1 && !limit) return dp[pos][flag];
        int res = 0, up = limit ? arr[pos] : 9;
        for (int i = 0; i <= up; i++) {
            if (i == 3 || i == 4 || i == 7) continue;
            if (i == 0 || i == 1 || i == 8) res += dfs(pos - 1, flag, i == up && limit);
            else res += dfs(pos - 1, 1, i == up && limit);
        }
        if (!limit) dp[pos][flag] = res;
        return res;
    }
}
