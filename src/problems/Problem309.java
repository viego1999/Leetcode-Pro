package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem309
 * @since 2023/3/10 22:50
 */
public class Problem309 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，昨天已经卖出
        // dp[i][2]: 手上不持有股票，昨天之前卖出
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = dp[i - 1][1];
        }
        return dp[n - 1][1];
    }
}
