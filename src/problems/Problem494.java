package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem494
 * @since 2023/3/10 11:16
 */
public class Problem494 {
    public static void main(String[] args) {

    }

    // left - right = target
    // left + right = sum
    // left = (target + sum) / 2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, left;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum || ((target + sum) & 1) == 1) return 0;
        int[] dp = new int[(left = (target + sum) >> 1) + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = left; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[left];
    }

    public int findTargetSumWaysB(int[] nums, int target) {
        return backtrack(nums, 0, target);
    }

    public int backtrack(int[] nums, int i, int target) {
        if (i == nums.length) return target == 0 ? 1 : 0;
        return backtrack(nums, i + 1, target + nums[i]) + backtrack(nums, i + 1, target - nums[i]);
    }
}
