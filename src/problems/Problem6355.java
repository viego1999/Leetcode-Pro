package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6355
 * @since 2023/2/12 11:33
 */
public class Problem6355 {
    public static void main(String[] args) {

    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0, n = nums.length; i < n; i++) {
            int min = lower - nums[i], max = upper - nums[i], l1 = i + 1, r1 = n - 1, l2 = i + 1, r2 = n - 1;
            while (l1 < r1) {
                int m = l1 + r1 >> 1;
                if (nums[m] < min) l1 = m + 1;
                else r1 = m;
            }
            while (l2 < r2) {
                int m = l2 + r2 + 1 >> 1;
                if (nums[m] > max) r2 = m - 1;
                else l2 = m;
            }
            if (l1 <= l2 && l2 < n && nums[i] + nums[l2] <= upper && nums[i] + nums[l1] >= lower) ans += l2 - l1 + 1;
        }
        return ans;
    }
}
