package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1130
 * @since 2023/5/31 12:19
 */
public class Problem1130 {
    public static void main(String[] args) {

    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length, ans = 0, top = -1;
        int[] stack = new int[n];
        for (int a : arr) {
            while (top != -1 && stack[top] < a) {
                int b = stack[top--];
                if (top != -1 && stack[top] < a) ans += b * stack[top];
                else ans += b * a;
            }
            stack[++top] = a;
        }
        while (top > 0) ans += stack[top--] * stack[top];
        return ans;
    }
}
