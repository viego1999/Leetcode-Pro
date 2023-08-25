package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6537
 * @since 2023/3/4 20:34
 */
public class Problem6537 {
    public static void main(String[] args) {

    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length, l = 0, r = 0, t = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            int v = map.getOrDefault(nums[r], 0) + 1;
            t += v - 1;
            map.put(nums[r++], v);
            while (t >= k) {
                ans += n - r + 1;
                v = map.get(nums[l]) - 1;
                t -= v;
                map.put(nums[l++], v);
            }
        }
        return ans;
    }
}
