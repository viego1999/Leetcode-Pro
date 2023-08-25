package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6346
 * @since 2023/2/5 15:53
 */
public class Problem6346 {
    public static void main(String[] args) {

    }

    public int minCapability(int[] nums, int k) {
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int m = l + r >> 1, cnt = 0;
            for (int i = 0, j = -2; i < nums.length; i++) {
                if (nums[i] <= m && j != i - 1) {
                    cnt++;
                    j = i;
                }
            }
            if (cnt >= k) r = m;
            else l = m + 1;
        }
        return l;
    }
}
