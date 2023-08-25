package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6393
 * @since 2023/5/27 23:02
 */
public class Problem6393 {
    public static void main(String[] args) {

    }

    public long maxStrength(int[] nums) {
        int n = nums.length, l, r = n - 1;
        Arrays.sort(nums);
        long ans = 1L, max = nums[r];
        for (l = 0; l < n - 1; l += 2) {
            if (nums[l] < 0 && nums[l + 1] < 0) {
                ans *= (long) nums[l] * nums[l + 1];
                max = Math.max(max, ans);
            } else break;
        }
        for (; r >= l; r--) {
            if (nums[r] > 0) {
                ans *= nums[r];
                max = Math.max(max, ans);
            }
        }
        return max;
    }
}
