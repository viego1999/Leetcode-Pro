package problems;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 *
 * link: https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class Problem1493 {
    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, ans = 0, c0 = 0, c1 = 0, n = nums.length;
        while (right < n) {
            if (nums[right++] == 0) c0++;
            else c1++;
            while (c0 > 1) {
                if (nums[left++] == 0) c0--;
                else c1--;
            }
            ans = Math.max(ans, c1);
        }
        return ans == n ? n - 1 : ans;
    }

    public int longestSubarray_(int[] nums) {
        int max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int l = 0, r = 0;
                for (int j = i - 1; j >= 0 && nums[j] == 1; j--) l++;
                for (int j = i + 1; j < n && nums[j] == 1; j++) r++;
                max = Math.max(max, l + r);
            }
        }
        return max == 0 && nums[0] != 0 ? n - 1 : max;
    }
}
