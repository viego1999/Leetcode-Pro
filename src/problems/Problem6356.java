package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6356
 * @since 2023/2/12 12:28
 */
public class Problem6356 {
    public static void main(String[] args) {

    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length, t = 0;
        int[][] ans = new int[n][2];
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < 31 && j + i <= s.length(); j++) {
                map.putIfAbsent(s.substring(i, j + i), new int[]{i, i + j - 1});
            }
        }
        for (int[] q : queries) {
            int[] arr = map.get(Integer.toBinaryString(q[0] ^ q[1]));
            ans[t++] = arr == null ? new int[]{-1, -1} : arr;
        }
        return ans;
    }
}
