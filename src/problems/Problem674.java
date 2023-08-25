package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem674
 * @since 2023/3/10 23:37
 */
public class Problem674 {
    public static void main(String[] args) {

    }

    public int findLengthOfLCIS_(int[] nums) {
        int n = nums.length, ans = 1;
        for (int i = 1, j = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) j = 1;
            else j++;
            ans = Math.max(ans, j);
        }
        return ans;
    }

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length, i = 0, ans = 0;
        while (i < n) {
            int j = i;
            while (j < n - 1 && nums[j] < nums[j + 1]) j++;
            ans = Math.max(ans, j - i + 1);
            i = j + 1;
        }
        return ans;
    }
}
