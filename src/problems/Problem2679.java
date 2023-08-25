package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2679
 * @since 2023/7/4 19:13
 */
public class Problem2679 {
    public static void main(String[] args) {

    }

    public int matrixSum(int[][] nums) {
        int ans = 0, m = nums.length, n = nums[0].length;
        for (int i = 0; i < m; i++) Arrays.sort(nums[i]);
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, nums[i][j]);
            }
            ans += max;
        }
        return ans;
    }
}
