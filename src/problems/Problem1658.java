package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1658
 * @Date 2023/1/7 10:50
 */
public class Problem1658 {

    public static void main(String[] args) {

    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length, l = 0, r = 0, sum = 0, ans = n + 1;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
            sum += nums[i];
        }
        if ((sum -= x) <= 0) return sum == 0 ? n : -1;
        while (r < n) {
            r++;
            while (sums[r] - sums[l] > sum) {
                l++;
            }
            if (sums[r] - sums[l] == sum) {
                ans = Math.min(ans, n - (r - l));
            }
        }
        return ans == n + 1 ? -1 : ans;
    }

}
