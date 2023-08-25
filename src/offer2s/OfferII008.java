package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII008
 * @since 2023/3/5 22:31
 */
public class OfferII008 {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, l = 0, r = 0, ans = n + 1;
        long sum = 0;
        while (r < n) {
            sum += nums[r++];
            while (sum >= target) {
                ans = Math.min(ans, r - l);
                sum -= nums[l++];
            }
        }
        return ans == n + 1 ? 0 : ans;
    }
}
