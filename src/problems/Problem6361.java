package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6361
 * @since 2023/2/18 23:36
 */
public class Problem6361 {
    public static void main(String[] args) {

    }

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(nums[n - 1] - nums[2], Math.min(nums[n - 2] - nums[1], nums[n - 3] - nums[0]));
    }
}
