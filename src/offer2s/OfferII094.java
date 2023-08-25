package offer2s;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII094
 * @since 2023/5/22 17:41
 */
public class OfferII094 {
    public static void main(String[] args) {

    }

    public static int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n + 1][n + 1]; // dp[i][j] 表示 s[i-j]是否为回文串
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                if (cs[i - 1] == cs[j - 1]) {
                    dp[j][i] = i - 1 < j + 1 || dp[j + 1][i - 1];
                }
            }
        }
        int[] f = new int[n + 1]; // f[i] 表示 s[0-i]为回文串的最小分割次数
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 1; i <= n; i++) {
            if (dp[1][i]) f[i] = 0;
            else {
                for (int j = i; j > 0; j--) {
                    if (dp[j][i]) f[i] = Math.min(f[i], f[j - 1] + 1);
                }
            }
        }
        return f[n];
    }
}
