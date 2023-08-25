package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1144
 * @since 2023/2/27 11:01
 */
public class Problem1144 {
    public static void main(String[] args) {

    }

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(helper(nums, 0), helper(nums, 1));
    }

    public int helper(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 1, j = nums[0]; i < n; i++) {
            if ((i & 1) == k) {
                if (nums[i] <= j) ans += j - nums[i] + 1;
                j = nums[i];
            } else {
                if (nums[i] >= j) {
                    ans += nums[i] - j + 1;
                    j = j - 1;
                } else j = nums[i];
            }
        }
        return ans;
    }
}
