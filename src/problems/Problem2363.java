package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2363
 * @since 2023/2/28 0:25
 */
public class Problem2363 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        for (int[] item : items2) map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        ans.sort((x, y) -> x.get(0) - y.get(0));
        return ans;
    }
}
