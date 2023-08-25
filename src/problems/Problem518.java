package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem518
 * @since 2023/3/10 16:02
 */
public class Problem518 {
    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
