package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem982
 * @since 2023/3/4 10:11
 */
public class Problem982 {
    public static void main(String[] args) {

    }

    public int countTriplets(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            for (int i : nums) {
                int x = num & i;
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int num : nums) {
                if ((entry.getKey() & num) == 0) ans += entry.getValue();
            }
        }
        return ans;
    }
}
