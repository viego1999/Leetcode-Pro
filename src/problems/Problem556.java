package problems;

/**
 * 556. 下一个更大元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 *
 * 输入：n = 21
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 * link: https://leetcode.cn/problems/next-greater-element-iii/
 */
public class Problem556 {
    public static void main(String[] args) {

    }

    public int nextGreaterElement(int n) {
        int[] nums = new int[15];
        int len = 0, ans = 0, last;
        while (n != 0) {
            nums[len++] = n % 10;
            n /= 10;
        }
        int i = 0, j = 0, l = 0, r = 0;
        for (int a = 0; a < len - 1; a++) {
            if (nums[a] > nums[a + 1]) {
                i = r = a;
                j = a + 1;
                break;
            }
        }
        if (i == j) return -1;
        for (int k = 0; k <= i; k++) {
            if (nums[j] < nums[k]) {
                swap(nums, j, k);
                break;
            }
        }
        while (l < r) swap(nums, l++, r--);
        while (--len >= 0) {
            last = ans;
            ans = ans * 10 + nums[len];
            if (last != ans / 10) return -1;
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
