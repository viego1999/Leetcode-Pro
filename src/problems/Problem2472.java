package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2472
 * @since 2023/5/23 10:34
 */
public class Problem2472 {
    public static void main(String[] args) {

    }

    public int maxPalindromes(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] flag = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                if (cs[i - 1] == cs[j - 1]) flag[j][i] = j + 1 > i - 1 || flag[j + 1][i - 1];
            }
        }
        int[] dp = new int[n + 1]; // dp[i] 表示 s[1-i] 长度大于k的字串个数
        for (int i = k; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - k + 1; j > 0; j--) {
                if (flag[j][i]) dp[i] = Math.max(dp[i], dp[j - 1] + 1);
            }
        }
        return dp[n];
    }
}
