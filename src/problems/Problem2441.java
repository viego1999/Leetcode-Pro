package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2441
 * @since 2023/5/13 11:34
 */
public class Problem2441 {
    public static void main(String[] args) {

    }

    public int findMaxK(int[] nums) {
        boolean[] hash = new boolean[2005];
        int ans = -1;
        for (int num : nums) {
            if (hash[1000 - num]) {
                ans = Math.max(ans, Math.abs(num));
            }
            hash[num + 1000] = true;
        }
        return ans;
    }

    public int findMaxK_(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (int num : nums) {
            if (set.contains(-num)) {
                ans = Math.max(ans, Math.abs(num));
            }
            set.add(num);
        }
        return ans;
    }
}
