package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2293
 * @since 2023/1/15 0:09
 */
public class Problem2293 {

    public static void main(String[] args) {

    }

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            n /= 2;
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return nums[0];
    }
}
