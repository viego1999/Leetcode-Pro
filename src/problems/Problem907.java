package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem907 {
    public static void main(String[] args) {

    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = (int) 1e9 + 7;
        long ans = 0;
        // left/right[i]表示左/右边第一个比arr[i]小数索引
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            left[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) * arr[i];
        }
        return (int) (ans % mod);
    }

    public int sumSubarrayMins_(int[] arr) {
        int n = arr.length, mod = (int) 1e9 + 7;
        long ans = 0;
        // left/right[i]表示左/右边第一个比arr[i]小数索引
        int[] left = new int[n], right = new int[n];
        Deque<Integer> sl = new ArrayDeque<>(), sr = new ArrayDeque<>();
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!sl.isEmpty() && arr[sl.peek()] > arr[i]) {
                right[sl.pop()] = i;
            }
            sl.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!sr.isEmpty() && arr[sr.peek()] >= arr[i]) {
                left[sr.pop()] = i;
            }
            sr.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) * arr[i];
        }
        return (int) (ans % mod);
    }

    public int sumSubarrayMinsBf(int[] arr) {
        int n = arr.length, ans = 0, mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + arr[i]) % mod;
            for (int j = i + 1, t = arr[i]; j < n; j++) {
                ans = (ans + (t = Math.min(t, arr[j]))) % mod;
            }
        }
        return ans;
    }
}
