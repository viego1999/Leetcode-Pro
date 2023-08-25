package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem714
 * @since 2023/3/10 23:07
 */
public class Problem714 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        // dp0表示持有股票，dp1表示卖出股票
        int dp0 = -prices[0], dp1 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 - prices[i]);
            dp1 = Math.max(dp1, dp0 + prices[i] - fee);
        }
        return dp1;
    }
}
