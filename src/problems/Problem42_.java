package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem42_ {
    public static void main(String[] args) {

    }

    // 竖着求
    public int trap(int[] height) {
        int ans = 0, n = height.length, left = 0, right = n - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }
        }
        return ans;
    }

    /*
                     --
                    |  |
         --          --
        |  | ////// |  |
         --  --      --
        |  ||  | // |  |
         --  --  --  --
     */
    public int trapStack(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            // 横着求
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int j = stack.pop();
                if (!stack.isEmpty()) {
                    int k = stack.peek();
                    ans += (Math.min(height[i], height[k]) - height[j]) * (i - k - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }

    /*
                     --
                    |  |
         --          --
        |  | 11  !! |  |
         --  --  !!  --
        |  ||  | -- |  |
         --  --  --  --
     */
    public int trapDp(int[] height) {
        int ans = 0, n = height.length;
        int[] lefts = new int[n], rights = new int[n];
        lefts[0] = height[0];
        rights[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lefts[i] = Math.max(lefts[i - 1], height[i]);
            rights[n - i - 1] = Math.max(rights[n - i], height[n - i - 1]);
        }
        // 竖着着求
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(lefts[i], rights[i]) - height[i];
        }
        return ans;
    }
}
