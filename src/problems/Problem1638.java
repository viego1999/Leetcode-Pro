package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1638
 * @since 2023/3/27 21:04
 */
public class Problem1638 {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length(), ans = 0;
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = 0;
                for (int k = 0; k + i < n && k + j < m; k++) {
                    diff += cs1[i + k] != cs2[j + k] ? 1 : 0;
                    if (diff == 1) ans++;
                    else if (diff > 1) break;
                }
            }
        }
        return ans;
    }
}
