package offer2s;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII039
 * @since 2023/4/29 23:59
 */
public class OfferII039 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        int[] lefts = new int[n], rights = new int[n];
        Arrays.fill(rights, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rights[stack.pop()] = i;
            }
            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) ans = Math.max(ans, heights[i] * (rights[i] - lefts[i] - 1));
        return ans;
    }
}
