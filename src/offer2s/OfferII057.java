package offer2s;

import java.util.TreeSet;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII057
 * @since 2023/5/5 21:55
 */
public class OfferII057 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length, l = 0, r = 0;
        TreeSet<Long> set = new TreeSet<>();
        while (r < n) {
            Long ceil = set.ceiling((long) nums[r] - (long) t);
            if (l < r && ceil != null && Math.abs(ceil - nums[r]) <= t) return true;
            if (r - l >= k) set.remove((long) nums[l++]);
            set.add((long) nums[r++]);
        }
        return false;
    }
}
