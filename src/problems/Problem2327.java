package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2327
 * @since 2023/2/28 21:06
 */
public class Problem2327 {
    public static void main(String[] args) {

    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n + 1]; // 第i天知道秘密的人
        dp[1] = 1;
        int mod = (int) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            for (int j = i - delay; j > 0; j--) {
                if (i - j < forget) dp[i] = (dp[i] + dp[j]) % mod;
                else break;
            }
        }
        for (int i = 0; i < forget; i++) dp[0] = (dp[0] + dp[n - i]) % mod;
        return dp[0];
    }

    public int peopleAwareOfSecret_(int n, int delay, int forget) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 1});
        int mod = (int) 1e9 + 7, ans = 0;
        for (int i = 2; i <= n; i++) {
            if (i - list.get(0)[0] >= forget) list.remove(0);
            int cnt = 0;
            for (int[] arr : list) {
                if (i - arr[0] >= delay) cnt = (cnt + arr[1]) % mod;
                else break;
            }
            if (cnt > 0) list.add(new int[]{i, cnt});
        }
        for (int[] arr : list) ans = (ans + arr[1]) % mod;
        return ans;
    }
}
