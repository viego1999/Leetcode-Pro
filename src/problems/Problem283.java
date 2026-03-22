package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem283
 * @since 2026/3/20 22:44
 */
public class Problem283 {

    public void moveZeroes(int[] nums) {
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right] = tmp;
            }
        }
    }
}
