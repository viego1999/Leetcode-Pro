package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1170
 * @since 2023/6/10 10:07
 */
public class Problem1170 {
    public static void main(String[] args) {

    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length, m = words.length;
        int[] ans = new int[n], ws = new int[m];
        for (int i = 0; i < m; i++) {
            char min = 'z';
            int cnt = 0;
            for (char c : words[i].toCharArray()) {
                if (c < min) {
                    min = c;
                    cnt = 1;
                } else if (c == min) cnt++;
            }
            ws[i] = cnt;
        }
        Arrays.sort(ws);
        for (int i = 0; i < n; i++) {
            char min = 'z';
            int cnt = 0, l = 0, r = m;
            for (char c : queries[i].toCharArray()) {
                if (c < min) {
                    min = c;
                    cnt = 1;
                } else if (c == min) cnt++;
            }
            while (l < r) {
                int mid = l + r >> 1;
                if (cnt >= ws[mid]) l = mid + 1;
                else r = mid;
            }
            ans[i] = m - r;
        }
        return ans;
    }
}
