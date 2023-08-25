package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1031
 * @since 2023/4/26 13:55
 */
public class Problem1031 {
    public static void main(String[] args) {

    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums, firstLen, secondLen), helper(nums, secondLen, firstLen));
    }

    public int helper2(int[] nums, int firstLen, int secondLen) {
        int n = nums.length, lmax = 0, ans = 0;
        int[] sums = new int[n + 1];
        sums[0] = nums[0];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];
        for (int i = firstLen + secondLen; i <= n; i++) {
            // 枚举左边区间长度为firstLen的子数组和最大值
            lmax = Math.max(lmax, sums[i - secondLen] - sums[i - secondLen - firstLen]);
            ans = Math.max(ans, sums[i] - sums[i - secondLen] + lmax);
        }
        return ans;
    }

    public int helper(int[] nums, int firstLen, int secondLen) {
        int n = nums.length, l = 0, r = 0, s = 0, ans = 0;
        int[] a = new int[n], b = new int[n];
        while (r < n) {
            s += nums[r];
            while (r - l + 1 > firstLen) s -= nums[l++];
            if (r > 0) a[r] = Math.max(a[r - 1], s);
            else a[r] = s;
            r++;
        }
        r = l = n - 1;
        s = 0;
        while (l >= 0) {
            s += nums[l];
            while (r - l + 1 > secondLen) s -= nums[r--];
            if (l < n - 1) b[l] = Math.max(b[l + 1], s);
            else b[l] = s;
            l--;
        }
        for (int i = 0; i < n - 1; i++) ans = Math.max(ans, a[i] + b[i + 1]);
        return ans;
    }
}
