package problems;

public class Problem1827 {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums) {
        int ans = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(prev + 1, nums[i]);
            ans += prev - nums[i];
        }
        return ans;
    }
}
