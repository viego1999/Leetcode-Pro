package offer2s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII084
 * @since 2023/5/18 19:03
 */
public class OfferII084 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) continue;
            list.add(nums[i]);
            used[i] = true;
            backtrack(ans, nums, used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
