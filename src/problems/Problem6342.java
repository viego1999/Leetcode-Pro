package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6342
 * @since 2023/4/30 10:37
 */
public class Problem6342 {
    public static void main(String[] args) {
        System.out.println(firstCompleteIndex(new int[]{1,4,5,2,6,3}, new int[][]{{4,3,5}, {1,2, 6}}));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] idxs = map.get(arr[i]);
            if (++rows[idxs[0]] == n || ++cols[idxs[1]] == m) return i;
        }
        return -1;
    }
}
