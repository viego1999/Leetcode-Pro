package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1663
 * @since 2023/1/26 9:34
 */
public class Problem1663 {

    public static void main(String[] args) {

    }

    public String getSmallestString_(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int t = Math.max(1, k - (n - i) * 26);
            k -= t;
            sb.append((char) (96 + t));
        }
        return sb.toString();
    }

    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 26; i > 0 && k > 0; i--) {
            for (int j = 1, t = k / i; j <= t; j++) {
                if (k - i >= n - 1) {
                    sb.append((char) ('a' + i - 1));
                    k -= i;
                    n--;
                } else break;
            }
        }
        return sb.reverse().toString();
    }

}
