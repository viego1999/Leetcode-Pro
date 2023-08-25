package offer2s;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII038
 * @since 2023/4/29 23:51
 */
public class OfferII038 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, idx;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[idx = stack.pop()] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
