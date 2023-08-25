package problems;

public class Problem795 {
    public static void main(String[] args) {

    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, n = nums.length, l = 0, r = 0;
        while (r < n) {
            while (l < n && nums[l] > right) l++; // 找到第一个小于right的数
            r = l;
            int cur1 = 0, cur2 = 0; // cur1为小于left的组合数，cur2为小于right的组合数
            while (r < n && nums[r] <= right) {
                if (nums[r++] < left) ans -= ++cur1;
                else cur1 = 0;
                ans += ++cur2;
            }
            l = r;
        }
        return ans;
    }
}
