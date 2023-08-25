package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem1814 {
    public static void main(String[] args) {

    }

    public int countNicePairs(int[] nums) {
        int ans = 0, mod = (int) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int x = num, y = 0;
            while (x != 0) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            int sub = num - y, v = map.getOrDefault(sub, 0) + 1; // 反转之后差值相等就满足条件
            ans = (ans + v - 1) % mod;
            map.put(sub, v);
        }
        return ans;
    }
}
