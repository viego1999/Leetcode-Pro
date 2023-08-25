package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem474
 * @since 2023/3/10 12:19
 */
public class Problem474 {
    public static void main(String[] args) {

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0, one;
            for (char c : str.toCharArray()) {
                if (c == '0') zero++;
            }
            one = str.length() - zero;
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
