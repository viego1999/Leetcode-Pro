package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem739
 * @since 2026/3/1 23:10
 */
public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, top = 0;
        int[] stack = new int[n + 1], ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (top > 0 && temperatures[stack[top]] < temperatures[i]) ans[stack[top]] = i - stack[top--];
            stack[++top] = i;
        }
        return ans;
    }
}
