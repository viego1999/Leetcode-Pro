package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1172
 * @since 2023/4/29 15:59
 */
public class Problem1172 {

    /**
     * Your DinnerPlates object will be instantiated and called as such:
     * DinnerPlates obj = new DinnerPlates(capacity);
     * obj.push(val);
     * int param_2 = obj.pop();
     * int param_3 = obj.popAtStack(index);
     */
    static class DinnerPlates {
        List<Deque<Integer>> stacks = new ArrayList<>();
        TreeSet<Integer> notFull = new TreeSet<>(), notEmpty = new TreeSet<>((x, y) -> y - x);
        int capacity;

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (notFull.isEmpty()) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(val);
                stacks.add(stack);
                if (stack.size() < capacity) notFull.add(stacks.size() - 1);
                notEmpty.add(stacks.size() - 1);
            } else {
                int idx = notFull.first();
                Deque<Integer> stack = stacks.get(idx);
                stack.push(val);
                if (stack.size() == capacity) notFull.remove(idx);
                notEmpty.add(idx);
            }
        }

        public int pop() {
            if (notEmpty.isEmpty()) return -1;
            int idx = notEmpty.first();
            Deque<Integer> stack = stacks.get(idx);
            if (stack.size() == 1) notEmpty.remove(idx);
            notFull.add(idx);
            return stack.pop();
        }

        public int popAtStack(int index) {
            if (index < stacks.size() && !stacks.get(index).isEmpty()) {
                Deque<Integer> stack = stacks.get(index);
                if (stack.size() == 1) notEmpty.remove(index);
                notFull.add(index);
                return stack.pop();
            }
            return -1;
        }
    }
}
