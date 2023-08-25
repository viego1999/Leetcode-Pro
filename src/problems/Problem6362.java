package problems;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6362
 * @since 2023/2/19 10:50
 */
public class Problem6362 {
    public static void main(String[] args) {

    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int[] arr : nums1) {
            mp.put(arr[0], mp.getOrDefault(arr[0], 0) + arr[1]);
        }
        for (int[] arr : nums2) {
            mp.put(arr[0], mp.getOrDefault(arr[0], 0) + arr[1]);
        }
        int[][] ans = new int[mp.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i][1] = entry.getValue();
            i++;
        }
        return ans;
    }
}
