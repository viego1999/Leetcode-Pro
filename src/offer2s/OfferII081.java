package offer2s;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII081
 * @since 2023/5/18 18:32
 */
public class OfferII081 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, candidates, 0, target, new ArrayDeque<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] cs, int t, int target, Deque<Integer> deque) {
        if (target <= 0) {
            if (target == 0) ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = t; i < cs.length; i++) {
            deque.add(cs[i]);
            backtrack(ans, cs, i, target - cs[i], deque);
            deque.removeLast();
        }
    }
}
