package problems;

import java.util.*;

public class Problem6293 {

    public static void main(String[] args) {

    }

    public long f(int[] nums, int k) {
        long ans = 0;
        int n = nums.length, l = 0, r = 0, tmp = 0, v;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(nums[r], v = map.getOrDefault(nums[r++], 0) + 1);
            tmp += v - 1;
            while (tmp >= k) {
                ans += n - r + 1;
                map.put(nums[l], v = map.get(nums[l++]) - 1);
                tmp -= v;
            }
        }
        return ans;
    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length, t = 0, l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            int val = map.getOrDefault(nums[r], 0) + 1;
            map.put(nums[r++], val);
            t += val - 1;
            while (t >= k) {
                ans += n - r + 1;
                val = map.get(nums[l]) - 1;
                t -= val;
                map.put(nums[l++], val);
            }
        }
        return ans;
    }

}
