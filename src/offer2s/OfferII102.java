package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII102
 * @since 2023/5/23 11:07
 */
public class OfferII102 {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, left;
        for (int num : nums) sum += num;
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) return 0;
        int[] dp = new int[(left = (sum + target) / 2) + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = left; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[left];
    }

    public int findTargetSumWays_(int[] nums, int target) {
        return backtrack(nums, 0, target);
    }

    public int backtrack(int[] nums, int t, int target) {
        if (t == nums.length) return target == 0 ? 1 : 0;
        return backtrack(nums, t + 1, target + nums[t]) +
                backtrack(nums, t + 1, target - nums[t]);
    }
}
