package offer2s;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII010
 * @since 2023/3/5 23:30
 */
public class OfferII010 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int v = map.getOrDefault(sum - k, 0);
            ans += v;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public int subarraySum_(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i, a = 0; j < n; j++) {
                a += nums[j];
                if (a == k) ans++;
            }
        }
        return ans;
    }
}
