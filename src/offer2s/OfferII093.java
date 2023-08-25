package offer2s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII093
 * @since 2023/5/19 21:15
 */
public class OfferII093 {
    public static void main(String[] args) {

    }

    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        int[][] dp = new int[n][n];
        for (int j = 2; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int a = map.getOrDefault(arr[j] - arr[i], j);
                if (a < i) {
                    dp[i][j] = dp[a][i] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans == 0 ? 0 : ans + 2;
    }

    public int lenLongestFibSubseq_(int[] arr) {
        int ans = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j], idx, t = 0;
                while ((idx = Arrays.binarySearch(arr, a + b)) > 0) {
                    t++;
                    a = b;
                    b = arr[idx];
                }
                ans = Math.max(ans, t);
            }
        }
        return ans == 0 ? 0 : ans + 2;
    }
}
