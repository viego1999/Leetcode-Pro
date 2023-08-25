package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII089
 * @since 2023/5/19 11:04
 */
public class OfferII089 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }
}
