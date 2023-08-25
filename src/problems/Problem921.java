package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem921 {
    public static void main(String[] args) {

    }

    public int minAddToMakeValid(String s) {
        int l = 0, r = 0; // l-要加的右括号数量，r-要加的左括号数量
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else {
                if (l == 0) r++;
                else l--;
            }
        }
        return l + r;
    }

    public int minAddToMakeValid_(String s) {
        int l = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) l++;
                else stack.pop();
            }
        }
        return stack.size() + l;
    }
}
