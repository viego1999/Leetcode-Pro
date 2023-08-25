package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 532. 数组中的 k-diff 数对
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3：
 *
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 *
 * link: https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */
public class Problem532 {
    public static void main(String[] args) {

    }

    public int findPairs(int[] nums, int k) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (!set1.contains(num)) {
                if (set1.contains(num - k)) ans++;
                if (set1.contains(num + k)) ans++;
            }
            if (!set1.add(num) && k == 0) set2.add(num);
        }
        return k == 0  ? set2.size() : ans;
    }

    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, l = 0, r = 0, n = nums.length;
        for (; l < n; l++) {
            r = l + 1;
            if (l == 0 || nums[l] != nums[l - 1]) { // 去除重复
                while (r < n && nums[r] < nums[l] + k) r++; // r一定在l后面
                if (r < n && nums[r] == nums[l] + k) ans++;
            }
        }
        return ans;
     }
}
