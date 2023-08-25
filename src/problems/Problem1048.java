package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1048
 * @since 2023/4/27 16:02
 */
public class Problem1048 {
    public static void main(String[] args) {

    }

    public int longestStrChain(String[] words) {
        int n = words.length, ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int sub = words[i].length() - words[j].length();
                if (sub == 1) {
                    int a = 0, b = 0;
                    for (; a < words[i].length() && b < words[j].length(); a++) {
                        if (words[i].charAt(a) == words[j].charAt(b)) b++;
                    }
                    if (b == words[j].length()) dp[i] = Math.max(dp[i], dp[j] + 1);
                } else if (sub > 1) break;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
