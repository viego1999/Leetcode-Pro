package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2352
 * @since 2023/6/6 10:59
 */
public class Problem2352 {
    public static void main(String[] args) {

    }

    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int n = grid.length, ans = 0;
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int i : row) list.add(i);
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(grid[i][j]);
            ans += map.getOrDefault(list, 0);
        }
        return ans;
    }
}
