package problems;

import java.util.Arrays;

public class Problem891 {
    public static void main(String[] args) {

    }

    int flag = 1000000007;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = nums[0] - nums[n - 1];
        long index = 1L;
        for (int i = 1; i < n; i++) {
            index = (index << 1) % flag;
            long x = (long) (nums[i] - nums[n - i - 1]) * index;
            sum = (sum + x) % flag;
        }
        return (int) sum;
    }
}
