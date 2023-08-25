package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem279
 * @since 2023/3/10 20:01
 */
public class Problem279 {
    public static void main(String[] args) {

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) { // 物品
            for (int j = i * i; j <= n; j++) { // 背包重量
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
