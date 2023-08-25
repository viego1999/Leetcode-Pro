package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1238
 * @since 2023/2/23 9:31
 */
public class Problem1238 {
    public static void main(String[] args) {
        System.out.println(circularPermutation(2, 3));
        System.out.println(circularPermutation(3, 2));
        System.out.println(circularPermutation(7, 12));
    }

    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        for (int i = 1; i <= n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(((ans.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ans;
    }

    public static List<Integer> circularPermutationBacktrack(int n, int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[] used = new boolean[1 << n];
        used[start] = true;
        backtrack(deque, n, start, used);
        return new ArrayList<>(deque);
    }

    public static void backtrack(Deque<Integer> deque, int n, int cur, boolean[] used) {
        if (deque.size() == 1 << n) return;
        for (int i = 0, t; i < n; i++) {
            int next = cur ^ (1 << i);
            if (used[next]) continue;
            if (((t = (deque.getLast() ^ next)) & (t - 1)) == 0 &&
                    (deque.size() < (1 << n) || ((t = (deque.getFirst() ^ deque.getLast())) & (t - 1)) == 0)) {
                used[next] = true;
                deque.add(next);
                backtrack(deque, n, next, used);
                if (deque.size() == 1 << n) return; // 如果 deque 的长度达到了最大长度，则停止回溯
                used[next] = false;
                deque.removeLast();
            }
        }
    }
}
