package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1775
 * @since 2023/3/4 20:06
 */
public class Problem1775 {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n * 6 || n > m * 6) return -1;
        int sum1 = 0, sum2 = 0, ans = 0;
        for (int num : nums1) sum1 += num;
        for (int num : nums2) sum2 += num;
        if (sum1 < sum2) return minOperations(nums2, nums1);
        if (sum1 == sum2) return 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = m - 1, j = 0, sub = sum1 - sum2;
        while (sub > 0 && (i >= 0 || j < n)) {
            int a = 0, b = 0;
            if (i >= 0) {
                int t1 = Math.max(nums1[i] - sub, 1);
                a = nums1[i] - t1;
            }
            if (j < n) {
                int t2 = Math.min(nums2[j] + sub, 6);
                b = t2 - nums2[j];
            }
            if (a > b) {
                sub -= a;
                i--;
            } else {
                sub -= b;
                j++;
            }
            ans++;
        }
        return ans;
    }
}
