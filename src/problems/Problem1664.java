package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1664
 * @since 2023/1/28 12:06
 */
public class Problem1664 {
    public static void main(String[] args) {

    }

    public int waysToMakeFair(int[] nums) {
        int n = nums.length, ans = 0, a = 0, b = 0, t1 = 0, t2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) a += nums[i];
            else b += nums[i];
        }
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                a -= nums[i];
                if (t1 + b == t2 + a) ans++;
                t1 += nums[i];
            } else {
                b -= nums[i];
                if (t2 + a == t1 + b) ans++;
                t2 += nums[i];
            }
        }
        return ans;
    }

    public int waysToMakeFair_(int[] nums) {
        int n = nums.length, ans = 0;
        int[] arr1 = new int[n + 1], arr2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                arr1[i] = arr1[i - 1] + nums[i - 1];
                arr2[i] = arr2[i - 1];
            } else {
                arr1[i] = arr1[i - 1];
                arr2[i] = arr2[i - 1] + nums[i - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            int t1 = arr1[i - 1] + arr2[n] - arr2[i];
            int t2 = arr2[i - 1] + arr1[n] - arr1[i];
            if (t1 == t2) ans++;
        }
        return ans;
    }
}
