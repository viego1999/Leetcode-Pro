package offer2s;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII011
 * @since 2023/3/7 9:17
 */
public class OfferII011 {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        int ans = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) ans = Math.max(ans, i - map.get(sum));
            else map.put(sum, i);
        }
        return ans;
    }
}
