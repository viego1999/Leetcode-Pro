package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1033
 * @since 2023/4/30 14:20
 */
public class Problem1033 {
    public static void main(String[] args) {

    }

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c}, ans = new int[2];
        Arrays.sort(arr);
        int i = arr[1] - arr[0], j = arr[2] - arr[1];
        int min = Math.min(i, j), max = Math.max(i, j);
        if (min == 1) ans[0] = Math.min(1, max / 2);
        else ans[0] = Math.min(min / 2 + min % 2, 2);
        ans[1] = i + j - 2;
        return ans;
    }

    public int[] numMovesStones_(int a, int b, int c) {
        int[] arr = new int[]{a, b, c}, ans = new int[2];
        Arrays.sort(arr);
        int i = arr[1] - arr[0], j = arr[2] - arr[1];
        int min = Math.min(i, j), max = Math.max(i, j);
        ans[0] = min == 1 ? (max == 1 ? 0 : 1) : min == 2 ? 1 : 2;
        ans[1] = i + j - 2;
        return ans;
    }
}
