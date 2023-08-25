package offer2s;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII119
 * @since 2023/5/30 21:51
 */
public class OfferII119 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num, len = 0;
                while (set.contains(curNum++)) len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public int longestConsecutive_(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = Math.min(n, 1);
        for (int i = 1, cnt = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) ans = Math.max(ans, ++cnt);
            else if (nums[i] != nums[i - 1])  cnt = 1;
        }
        return ans;
    }
}
