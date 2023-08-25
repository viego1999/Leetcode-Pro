package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII101
 * @since 2023/5/22 21:32
 */
public class OfferII101 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int avg = sum / 2;
        int[] dp = new int[avg + 1];
        for (int num : nums) {
            for (int j = avg; j > 0; j--) {
                if (num <= j) dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[avg] == avg;
    }
}
