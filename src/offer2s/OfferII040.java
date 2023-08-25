package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII040
 * @since 2023/4/30 16:43
 */
public class OfferII040 {
    public static void main(String[] args) {

    }

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length(), ans = 0;
        int[][] rows = new int[m + 1][n + 1], cols = new int[m + 1][n + 1], sums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int t = matrix[i - 1].charAt(j - 1) - '0';
                rows[i][j] = t == 0 ? 0 : (rows[i][j - 1] + 1);
                cols[i][j] = t == 0 ? 0 : (cols[i - 1][j] + 1);
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + t;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = rows[i][j]; k > 0; k--) {
                    for (int l = cols[i][j]; l > 0; l--) {
                        if (sums[i][j] - sums[i][j - k] - sums[i - l][j] + sums[i - l][j - k] == k * l) {
                            ans = Math.max(ans, k * l);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
