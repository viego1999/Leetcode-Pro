package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2475
 * @since 2023/6/13 10:39
 */
public class Problem2475 {
    public static void main(String[] args) {
        
    }

    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 1; j < n - 1;) {
            while (j < n && nums[j] == nums[i]) j++;
            if (j < n) ans += (j - i) * i * (n - j);
            i = j;
        }
        return ans;
    }

    public int unequalTripletsMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        if (map.size() < 3) return 0;
        int ans = 0, a = 0, b, c = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            b = entry.getValue();
            c -= b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }
}
