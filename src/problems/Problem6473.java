package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6473
 * @since 2023/6/11 11:04
 */
public class Problem6473 {
    public static void main(String[] args) {

    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        int[][] sums = new int[n][3];
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) sums[i] = new int[]{nums1[i] + nums2[i], nums1[i], nums2[i]};
        Arrays.sort(sums, (x, y) -> y[0] - x[0]);
        for (int i = 0; i < m; i++) {
            int x = queries[i][0], y = queries[i][1];
            for (int j = 0; j < n; j++) {
                if (sums[j][1] >= x && sums[j][2] >= y) {
                    ans[i] = sums[j][0];
                    break;
                }
            }
        }
        return ans;
    }
}
