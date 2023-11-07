package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2605
 * @since 2023/9/5 11:40
 */
public class Problem2605 {
    public static void main(String[] args) {

    }

    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int min1 = 0x3f3f3f3f, min2 = min1, ans = min1;
        for (int num : nums1) {
            set.add(num);
            min1 = Math.min(min1, num);
        }
        for (int num : nums2) {
            if (set.contains(num) && num < ans) ans = num;
            min2 = Math.min(min2, num);
        }
        int a1 = min1 * 10 + min2, a2 = min2 * 10 + min1;
        return Math.min(ans, Math.min(a1, a2));
    }
}
