package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2395
 * @since 2023/3/26 12:45
 */
public class Problem2395 {
    public static void main(String[] args) {

    }

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!set.add(nums[i] + nums[i - 1])) return true;
        }
        return false;
    }
}
