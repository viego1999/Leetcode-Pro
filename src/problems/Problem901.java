package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem901 {
    public static void main(String[] args) {

    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
    static class StockSpanner {
        Deque<int[]> stack = new ArrayDeque<>();
        int idx = -1;

        public StockSpanner() {
            stack.push(new int[] {-1, Integer.MAX_VALUE});
        }

        public int next(int price) {
            while (stack.peek()[1] <= price) stack.pop();
            int last = stack.peek()[0];
            stack.push(new int[]{++idx, price});
            return idx - last;
        }
    }

    static class StockSpanner_ {
        Deque<int[]> stack = new ArrayDeque<>();
        int idx = -1;

        public int next(int price) {
            while (!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
            int last = stack.isEmpty() ? -1 : stack.peek()[0];
            stack.push(new int[]{++idx, price});
            return idx - last;
        }
    }
}
