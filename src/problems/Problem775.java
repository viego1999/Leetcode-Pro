package problems;

public class Problem775 {
    public static void main(String[] args) {

    }

    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, max = nums[0];
        for (int i = 2; i < n; i++) {
            if (nums[i] < max) return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }

    public boolean isIdealPermutation_(int[] nums) {
        int n = nums.length, min = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > min) return false;
            min = Math.min(min, nums[i + 1]);
        }
        return true;
    }
}
