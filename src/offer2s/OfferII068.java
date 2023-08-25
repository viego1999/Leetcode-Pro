package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII068
 * @since 2023/5/14 22:31
 */
public class OfferII068 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length, l = 0, r = n;
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
