package offer2s;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII080
 * @since 2023/5/18 18:26
 */
public class OfferII080 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, n, 1, k, new ArrayDeque<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int n, int t, int k, Deque<Integer> deque) {
        if (deque.size() + (n - t + 1) < k) return;
        if (deque.size() == k) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = t; i <= n; i++) {
            deque.add(i);
            backtrack(ans, n, i + 1, k, deque);
            deque.removeLast();
        }
    }
}
