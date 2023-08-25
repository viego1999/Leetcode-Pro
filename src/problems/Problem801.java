package problems;

import java.util.Arrays;

public class Problem801 {
    public static void main(String[] args) {

    }

    public int minSwapDp(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], n);
        dp[0][0] = 0; // 在位置i时不交换满足条件的最小交换次数
        dp[0][1] = 1; // 在位置i时交换满足条件的最小交换次数
        for (int i = 1; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            // 上次不交换满足递增时
            if (a > nums1[i - 1] && b > nums2[i - 1]) {
                dp[i][0] = dp[i - 1][0]; // 这次也不交换
                dp[i][1] = dp[i - 1][1] + 1; // 如果这次交换，则在上次交换情况下再交换（保证满足条件）
            }
            // 上次交换后满足递增条件
            if (a > nums2[i - 1] && b > nums1[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]); // 取【上次不交换这次不交换】满足和【上次交换后这次不交换】满足最小值
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1); // 取【上次交换这次交换】满足和【上次不交换这次交换】满足最小值
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }


    public int minSwap(int[] nums1, int[] nums2) {
        int dp0 = 0, dp1 = 1, n = nums1.length;
        for (int i = 1; i < n; i++) {
            int a = dp0, b = dp1;
            dp0 = dp1 = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp0 = Math.min(dp0, a);
                dp1 = Math.min(dp1, b + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp0 = Math.min(dp0, b);
                dp1 = Math.min(dp1, a + 1);
            }
        }
        return Math.min(dp0, dp1);
    }
}
