package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem354 {
    public static void main(String[] args) {

    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        // lit.get(i)表示了长度为 i 的情况下，最后一个元素的大小
        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) f.add(num);
            else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public int maxEnvelopes_(int[][] envelopes) {
        int n = envelopes.length, ans = 1;
        Arrays.sort(envelopes, (x, y) -> x[0] - y[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
