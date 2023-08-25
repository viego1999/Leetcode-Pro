package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6464
 * @since 2023/5/27 23:15
 */
public class Problem6464 {
    public static void main(String[] args) {
        Problem6464 problem6464 = new Problem6464();
        System.out.println(problem6464.canTraverseAllPairs(new int[]{6, 3, 15}));
    }

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>(), visited = new HashMap<>();
        for (int num : nums) {
            if (num == 1) return false;
            List<Integer> list = new ArrayList<>();
            // 试除法分解质因数
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    list.add(i);
                    while (num % i == 0) num /= i;
                }
            }
            if (num > 1) list.add(num);
            map.putIfAbsent(list.get(0), new HashSet<>());
            for (int i = 1; i < list.size(); i++) {
                map.computeIfAbsent(list.get(i - 1), t -> new HashSet<>()).add(list.get(i));
                map.computeIfAbsent(list.get(i), t -> new HashSet<>()).add(list.get(i - 1));
            }
        }
        dfs(map.keySet().iterator().next(), map, visited);
        return map.size() == visited.size();
    }

    private void dfs(int u, Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> visited) {
        if (visited.put(u, new HashSet<>()) == null) {
            for (int v : map.get(u)) {
                dfs(v, map, visited);
            }
        }
    }
}