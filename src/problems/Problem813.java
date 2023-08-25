package problems;

public class Problem813 {
    public static void main(String[] args) {

    }

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) dp[i][1] = sums[i] * 1. / i;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                for (int l = 1; l < i; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (sums[i] - sums[l]) * 1. / (i - l));
                }
            }
        }
        return dp[n][k];
    }
}
