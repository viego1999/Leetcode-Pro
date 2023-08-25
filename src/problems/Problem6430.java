package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6430
 * @since 2023/5/14 11:23
 */
public class Problem6430 {
    public static void main(String[] args) {

    }

    public int[] circularGameLosers(int n, int k) {
        boolean[] hash = new boolean[n];
        int cur = 0, step = 1, s = 0;
        while (!hash[cur]) {
            hash[cur] = true;
            cur = (cur + step * k) % (n);
            step++;
        }
        for (int i = 0; i < n; ++i) if (hash[i]) s++;
        int[] ans = new int[n - s];
        for (int i = 0, x = 0; i < n; ++i) {
            if (!hash[i]) ans[x++] = i + 1;
        }
        return ans;
    }
}
