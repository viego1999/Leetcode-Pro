package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII088
 * @since 2023/5/18 22:53
 */
public class OfferII088 {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
