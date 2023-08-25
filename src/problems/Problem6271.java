package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Problem6271 {
    public static void main(String[] args) {

    }

    public int maximumTastiness(int[] price, int k) {
        return backtrack(price, 0, k, 0, new int[k]);
    }

    public int backtrack(int[] price, int idx, int k, int t, int[] arr) {
        if (k == t) {
            int ans = 0;
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    ans = Math.max(ans, Math.abs(price[i] - price[j]));
                }
            }
            return ans;
        }
        if (idx == price.length) return 0;
        int a = backtrack(price, idx + 1, k, t, arr);
        arr[t] = price[idx];
        int b = backtrack(price, idx + 1, k, t + 1, arr);
        return Math.max(a, b);
    }

    // 1,2,5,8,13,21
    public int maximumTastiness_(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length, l = 0, r = price[n - 1];
        while (l < r) {
            int m = l + r + 1 >> 1;
            int cur = 1, last = price[0];
            for (int i = 1; i < n; i++) {
                if (price[i] - last >= m) {
                    cur++;
                    last = price[i];
                }
            }
            if (cur < k) r = m - 1; // 当前符合条件的个数小，
            else l = m;
        }
        return l;
    }
}
