package offer2s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII007
 * @since 2023/3/5 22:04
 */
public class OfferII007 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0, n = nums.length; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum == 0) {
                            ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                        } else if (sum > 0) k--;
                        else j++;
                    } else j++;
                }
            }
        }
        return ans;
    }
}
