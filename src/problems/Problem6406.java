package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6406
 * @since 2023/4/29 22:43
 */
public class Problem6406 {
    public static void main(String[] args) {

    }

    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int i : nums) max = Math.max(max, i);
        return (2 * max + k - 1) * k / 2;
    }
}
