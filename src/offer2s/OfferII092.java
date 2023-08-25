package offer2s;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII092
 * @since 2023/5/19 17:06
 */
public class OfferII092 {
    public static void main(String[] args) {

    }

    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1, j = 0; i <= n; i++) {
            if (cs[i - 1] == '1') {
                dp[i] = dp[i - 1];
                j++;
            } else dp[i] = Math.min(j, dp[i - 1] + 1);
        }
        return dp[n];
    }
}
