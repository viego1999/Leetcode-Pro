package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem6241 {
    public static void main(String[] args) {

    }

    public int unequalTripletsBf(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) ans++;
                }
            }
        }
        return ans;
    }

    /*
     *  在 x 之前遍历过的数有 a 个；
     *  （当前遍历的）等于 x 的数有bb 个；
     *  在 x 之后遍历过的数有 c 个。
     */
    public static int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        if (map.size() < 3) return 0;
        int ans = 0, a = 0, c = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int b = entry.getValue();
            c -= b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }

    public static int combination(int m, int n) {
        int sum1 = 1, sum2 = 1;
        for (int i = n; i > n - m; i--) sum1 *= i;
        for (int i = m; i > 0; i--) sum2 *= i;
        return sum1 / sum2;
    }
}
