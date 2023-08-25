package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII012
 * @since 2023/3/11 23:11
 */
public class OfferII012 {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        for (int i = 0, j = 0; i < n; i++) {
            if (j == sum - j - nums[i]) return i;
            j += nums[i];
        }
        return -1;
    }
}
