package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII104
 * @since 2023/5/23 15:40
 */
public class OfferII104 {
    public static void main(String[] args) {

    }

    // 求组合数就是外层for循环遍历物品，内层for遍历背包
    // 求排列数就是外层for遍历背包，内层for循环遍历物品
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
