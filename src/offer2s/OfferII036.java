package offer2s;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII036
 * @since 2023/4/29 17:09
 */
public class OfferII036 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = stack.pop(), a = stack.pop();
                stack.push(s.equals("+") ? a + b : s.equals("-") ? a - b : s.equals("*") ? a * b : a / b);
            } else stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }
}
