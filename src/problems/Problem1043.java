package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1043
 * @since 2023/4/19 14:36
 */
public class Problem1043 {
    public static void main(String[] args) {
        
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                if (j > 0) max = Math.max(max, arr[j - 1]);
            }
        }
        return dp[n];
    }
}
