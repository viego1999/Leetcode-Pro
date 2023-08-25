package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1817 {

    public static void main(String[] args) {
        
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.computeIfAbsent(log[0], key -> new HashSet<>()).add(log[1]);
        }
        for (Set<Integer> set : map.values()) ans[set.size() - 1]++;
        return ans;
    }

}
