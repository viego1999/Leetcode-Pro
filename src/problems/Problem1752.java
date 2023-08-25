package problems;

public class Problem1752 {
    public static void main(String[] args) {

    }

    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (!flag && nums[0] >= nums[i] && nums[i] < nums[i - 1]) flag = true;
            else if (nums[i] < nums[i - 1] || (flag && nums[i] > nums[0])) return false;
        }
        return true;
    }
}
