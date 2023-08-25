package problems;

public class Problem1800 {
    public static void main(String[] args) {

    }

    public int maxAscendingSum(int[] nums) {
        int ans = 0, n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) sum += nums[i];
            else sum = nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
