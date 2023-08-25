package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII070
 * @since 2023/5/15 21:08
 */
public class OfferII070 {
    public static void main(String[] args) {

    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while (l < r) {
            int m = l + r >> 1;
            if ((m & 1) == 0) {
                if (nums[m] == nums[m + 1]) l = m + 1;
                else r = m;
            } else {
                if (nums[m] == nums[m - 1]) l = m + 1;
                else r = m;
            }
        }
        return nums[l];
    }

    public int singleNonDuplicate_(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] == nums[m ^ 1]) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
}
