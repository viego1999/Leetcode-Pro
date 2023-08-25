package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6394
 * @since 2023/5/27 22:36
 */
public class Problem6394 {
    public static void main(String[] args) {
        System.out.println(minExtraChar("leetscode", new String[]{"leet", "code"}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}
