package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6424
 * @since 2023/6/4 12:10
 */
public class Problem6424 {
    public static void main(String[] args) {

    }

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length, a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) a = i;
            else if (nums[i] == n) b = i;
        }
        if (a < b) {
            return a - 1 + n - b; // 1 2
        } else return a - 2 + n - b; // 2 1
    }
}
