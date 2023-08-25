package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1590
 * @since 2023/3/10 0:52
 */
public class Problem1590 {
    public static void main(String[] args) {

    }

    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n, remain = 0;
        for (int num : nums) remain = (remain + num) % p;
        if (remain == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, s = 0, t; i < n; i++) {
            map.put(s, i);
            s = (s + nums[i]) % p;
            t = (s - remain + p) % p;
            if (map.containsKey(t)) ans = Math.min(ans, i - map.get(t) + 1);
        }
        return ans == n ? -1 : ans;
    }
}
