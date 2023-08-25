package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem856 {
    public static void main(String[] args) {

    }

    public int scoreOfParentheses_(String s) {
        int n = s.length(), top = 0;
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') stack[++top] = 0;
            else {
                int t = stack[top--];
                stack[top] += Math.max(1, 2 * t);
            }
        }
        return stack[top];
    }

    public int scoreOfParentheses(String s) {
        int ans = 0, level = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') level++;
            else {
                level--;
                if (s.charAt(i - 1) == '(') ans += 1 << level;
            }
        }
        return ans;
    }

    int idx = 0;

    public int scoreOfParenthesesDfs(String s) {
        int ans = 0, n = s.length();
        while (idx < n && s.charAt(idx) == '(') {
            idx++;
            if (s.charAt(idx) == ')') ans += 1;
            else ans += scoreOfParenthesesDfs(s) * 2;
            idx++;
        }
        return ans;
    }

    public int scoreOfParenthesesStack(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(0);
            else {
                int cur = stack.pop();
                stack.push(stack.pop() + Math.max(cur * 2, 1));
            }
        }
        return stack.pop();
    }
}
