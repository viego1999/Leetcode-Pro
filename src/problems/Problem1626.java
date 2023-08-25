package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1626
 * @since 2023/3/22 17:38
 */
public class Problem1626 {
    public static void main(String[] args) {

    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) array[i] = new int[]{scores[i], ages[i]};
        Arrays.sort(array, (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] dp = new int[n]; // dp[i]表示选第i个人时的最大分数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[i][1] <= array[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i][0]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
