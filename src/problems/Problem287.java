package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem287
 * @since 2026/3/22 19:37
 */
public class Problem287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int head = 0;
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return head;
    }

    public int findDuplicate2(int[] nums) { // 二分
        int l = 0, r = nums.length - 1, ans = 0;
        while (l <= r) {
            int m = l + r >> 1, cnt = 0;
            for (int num : nums) cnt += num <= m ? 1 : 0;
            if (cnt <= m) l = m + 1;
            else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }
}
