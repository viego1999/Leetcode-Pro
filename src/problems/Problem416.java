package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem416
 * @since 2026/3/22 18:17
 */
public class Problem416 {

    public boolean canPartition(int[] nums) {
        int sum = 0, avg;
        for (int num : nums) sum += num;
        if ((sum & 1) != 0) return false;
        boolean[] dp = new boolean[(avg = sum / 2) + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = avg; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[avg];
    }
}
