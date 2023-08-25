package offer2s;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII082
 * @since 2023/5/18 18:40
 */
public class OfferII082 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > t && cs[i] == cs[i - 1]) continue;
            deque.add(cs[i]);
            backtrack(ans, cs, i + 1, target - cs[i], deque);
            deque.removeLast();
        }
    }
}
