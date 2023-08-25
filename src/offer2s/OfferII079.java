package offer2s;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII079
 * @since 2023/5/18 17:00
 */
public class OfferII079 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, 0, new ArrayDeque<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, int t, Deque<Integer> deque) {
        ans.add(new ArrayList<>(deque));
        for (int i = t; i < nums.length; i++) {
            deque.add(nums[i]);
            backtrack(ans, nums, i + 1, deque);
            deque.removeLast();
        }
    }
}
