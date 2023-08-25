package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII009
 * @since 2023/3/5 22:46
 */
public class OfferII009 {
    public static void main(String[] args) {

    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long mul = 1;
        int n = nums.length, l = 0, r = 0, ans = 0;
        while (r < n) {
            mul *= nums[r++];
            while (l < r && mul >= k) {
                mul /= nums[l++];
            }
            if (mul < k) ans += r - l;
        }
        return ans;
    }
}
