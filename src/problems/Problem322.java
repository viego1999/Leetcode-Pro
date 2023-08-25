package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem322
 * @since 2023/3/10 17:19
 */
public class Problem322 {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }
}
