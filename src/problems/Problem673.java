package problems;

public class Problem673 {
    public static void main(String[] args) {

    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 0, ans = 0;
        // 以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]
        int[] dp = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cnt[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置cnt[i]
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < n; i++) if (dp[i] == max) ans += cnt[i];
        return ans;
    }
}
