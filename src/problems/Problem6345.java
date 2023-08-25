package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6345
 * @since 2023/2/5 11:52
 */
public class Problem6345 {
    public static void main(String[] args) {

    }

    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length, min = Integer.MAX_VALUE;
        Map<Integer, Integer> cnts = new HashMap<>(), cnts1 = new HashMap<>(), cnts2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnts.put(basket1[i], cnts.getOrDefault(basket1[i], 0) + 1);
            cnts.put(basket2[i], cnts.getOrDefault(basket2[i], 0) + 1);
            cnts1.put(basket1[i], cnts1.getOrDefault(basket1[i], 0) + 1);
            cnts2.put(basket2[i], cnts2.getOrDefault(basket2[i], 0) + 1);
            min = Math.min(min, Math.min(basket1[i], basket2[i]));
        }
        for (int cnt : cnts.values()) if ((cnt & 1) == 1) return -1;
        List<Integer> nums = new ArrayList<>(); // 存储要移动的数
        for (int num : cnts.keySet()) {
            int sub = Math.abs(cnts1.getOrDefault(num, 0) - cnts2.getOrDefault(num, 0));
            if (sub > 0) { // 数量不相等，需要将差值数量的一半的num从一堆移动到另一堆
                for (int i = 0; i < sub / 2; i++) nums.add(num);
            }
        }
        nums.sort((x, y) -> x - y);
        long ans = 0;
        // 统计结果
        for (int i = 0; i < nums.size() / 2; i++) ans += Math.min(nums.get(i), 2 * min);
        return ans;
    }
}
