package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1003
 * @since 2023/5/3 10:46
 */
public class Problem1003 {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        int n = s.length(), top = -1;
        char[] stack = new char[n + 1];
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (top < 1 || stack[top--] != 'b' || stack[top--] != 'a') return false;
            } else stack[++top] = c;
        }
        return top == -1;
    }
}
