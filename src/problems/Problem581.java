package problems;

public class Problem581 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[n - 1], left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) right = i;
            else max = nums[i];
            if (min < nums[n - i - 1]) left = n - i - 1;
            else min = nums[n - i - 1];
        }
        return right != -1 ? right - left + 1 : 0;
    }
}
