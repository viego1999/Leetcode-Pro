package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2389
 * @since 2023/3/17 0:35
 */
public class Problem2389 {
    public static void main(String[] args) {

    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[] ans = new int[m], sums = new int[n + 1];
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];
        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (sums[mid] > queries[i]) r = mid - 1;
                else l = mid;
            }
            ans[i] = l;
        }
        return ans;
    }
}
