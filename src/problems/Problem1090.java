package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1090
 * @since 2023/5/23 9:51
 */
public class Problem1090 {
    public static void main(String[] args) {

    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length, ans = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{values[i], labels[i]};
        Arrays.sort(arr, (x, y) -> y[0] - x[0]);
        int[] cnts = new int[20005];
        for (int i = 0, j = 0; i < n && j < numWanted; i++) {
            if (cnts[arr[i][1]] < useLimit) {
                ans += arr[i][0];
                cnts[arr[i][1]]++;
                j++;
            }
        }
        return ans;
    }
}
