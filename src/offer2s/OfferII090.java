package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII090
 * @since 2023/5/19 14:48
 */
public class OfferII090 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n], dp2 = new int[n];
        dp1[1] = nums[0];
        dp2[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
