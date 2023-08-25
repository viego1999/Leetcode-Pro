package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6396
 * @since 2023/6/4 11:05
 */
public class Problem6396 {
    public static void main(String[] args) {
        Problem6396 p = new Problem6396();
        System.out.println(p.count("1", "12", 1, 8));
        System.out.println(p.count("1000000007", "2000000014", 1, 400));
    }

    int[][] dp = new int[25][200];
    int min_sum = 0, max_sum = 0, mod = (int) 1e9 + 7;
    char[] cs;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        int ans = solve(num2) - solve(num1), sum = 0;
        for (char c : num1.toCharArray()) sum += (c - '0');
        if (sum >= min_sum && sum <= max_sum) ans++;
        return (ans + mod) % mod;
    }

    public int solve(String num) {
        this.cs = num.toCharArray();
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(0, 0, true);
    }

    public int dfs(int pos, int sum, boolean limit) {
        if (pos == this.cs.length) return sum >= min_sum ? 1 : 0;
        if (!limit && dp[pos][sum] != -1) return dp[pos][sum];
        int res = 0, up = limit ? cs[pos] - '0' : 9;
        for (int i = 0; i <= up; i++) {
            if (sum + i <= max_sum)
                res = (res + dfs(pos + 1, sum + i, limit && i == up)) % mod;
        }
        if (!limit) dp[pos][sum] = res;
        return res;
    }
}
