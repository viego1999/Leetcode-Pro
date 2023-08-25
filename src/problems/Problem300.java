package problems;

import java.util.Arrays;

public class Problem300 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int[] array = new int[n];
        for (int num : nums) {
            int l = 0, r = ans;
            while (l < r) {
                int m = l + r >> 1;
                if (array[m] < num) l = m + 1;
                else r = m;
            }
            array[l] = num;
            if (r == ans) ans++;
        }
        return ans;
    }

    // dp
    public int lengthOfLISDp(int[] nums) {
        int n = nums.length, ans = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
