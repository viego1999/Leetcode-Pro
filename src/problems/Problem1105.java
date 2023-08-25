package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1105
 * @since 2023/4/23 23:14
 */
public class Problem1105 {
    public static void main(String[] args) {

    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1]; // dp[i]表示将书0-i放置在书架的最小高度
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int curW = books[i - 1][0], maxH = books[i - 1][1];
            for (int j = i - 1; j >= 0; j--) {
                if (curW > shelfWidth) break;
                dp[i] = Math.min(dp[i], dp[j] + maxH);
                if (j > 0) {
                    curW += books[j - 1][0];
                    maxH = Math.max(maxH, books[j - 1][1]);
                }
            }
        }
        return dp[n];
    }
}
