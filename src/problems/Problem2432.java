package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2432
 * @since 2023/5/5 10:37
 */
public class Problem2432 {
    public static void main(String[] args) {

    }

    public int hardestWorker(int n, int[][] logs) {
        int m = logs.length, ans = logs[0][0], max = logs[0][1];
        for (int i = 1; i < m; i++) {
            int t = logs[i][1] - logs[i - 1][1];
            if (t > max) {
                ans = logs[i][0];
                max = t;
            } else if (t == max) ans = Math.min(ans, logs[i][0]);
        }
        return ans;
    }
}
