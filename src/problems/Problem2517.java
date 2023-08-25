package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2517
 * @since 2023/6/1 10:22
 */
public class Problem2517 {
    public static void main(String[] args) {

    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length, l = 0, r = price[n - 1] - price[0];
        while (l < r) {
            int m = l + r + 1 >> 1, cnt = 1;
            for (int i = 1, j = price[0]; i < n; i++) {
                if (price[i] - j >= m) {
                    j = price[i];
                    cnt++;
                }
            }
            if (cnt < k) r = m - 1;
            else l = m;
        }
        return l;
    }
}
