package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1124
 * @since 2023/2/14 10:17
 */
public class Problem1124 {
    public static void main(String[] args) {

    }

    public int longestWPI(int[] hours) {
        int n = hours.length, top = 0, ans = 0;
        int[] sums = new int[n + 1], stack = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] += sums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (sums[stack[top]] > sums[i]) stack[++top] = i;
        }
        for (int i = n; i > 0; i--) {
            while (top != -1 && sums[i] > sums[stack[top]]) {
                ans = Math.max(ans, i - stack[top--]);
            }
        }
        return ans;
    }

    public int longestWPIMap(int[] hours) {
        int n = hours.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, s = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) ans = i + 1;
            else {
                Integer t = map.get(s - 1); // 找到 s-t=1 的首次位置，此时 [t~s] 这段和大于0
                if (t != null) ans = Math.max(ans, i - t);
            }
            map.putIfAbsent(s, i); // 记录s首次出现的位置
        }
        return ans;
    }

    public int longestWPIBf(int[] hours) {
        int n = hours.length, ans = 0;
        int[] arr = new int[n];
        arr[0] = hours[0] > 8 ? 1 : -1;
        for (int i = 1; i < n; i++) arr[i] = hours[i] > 8 ? 1 : -1;
        for (int i = 0; i < n; i++) {
            for (int j = i, s = 0; j < n; j++) {
                s += arr[j];
                if (s > 0) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
