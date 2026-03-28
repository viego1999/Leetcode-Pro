package problems;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, r = 1;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        for (int j = n - 1; j >= 0; j--) {
            ans[j] *= r;
            r *= nums[j];
        }
        return ans;
    }

    public int[] productExceptSelf_(int[] nums) {
        int n = nums.length;
        int[] lefts = new int[n], rights = new int[n];
        lefts[0] = rights[n - 1] = 1;
        for (int i = 1; i < n; i++) lefts[i] = nums[i - 1] * lefts[i - 1];
        for (int j = n - 2; j >= 0; j--) rights[j] = nums[j + 1] * rights[j + 1];
        for (int i = 0; i < n; i++) lefts[i] *= rights[i];
        return lefts;
    }
}
