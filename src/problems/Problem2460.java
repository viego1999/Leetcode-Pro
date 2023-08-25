package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2460
 * @since 2023/6/5 10:41
 */
public class Problem2460 {
    public static void main(String[] args) {

    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length, l = 0, r = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        while (r < n) {
            while (l < n && nums[l] != 0) l++;
            r = l + 1;
            while (r < n && nums[r] == 0) r++;
            if (r < n) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }
}
