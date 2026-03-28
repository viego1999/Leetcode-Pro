package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem560 {

    public int subarraySum(int[] nums, int k) {
        int ans = 0, n = nums.length;
        int[] prefixSum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            int sub = prefixSum[i] - k;
            if (map.containsKey(sub)) ans += map.get(sub);
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return ans;
    }
}
