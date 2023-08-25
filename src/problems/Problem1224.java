package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1224. 最大相等频率
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 *
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * link: https://leetcode.cn/problems/maximum-equal-frequency/
 */
public class Problem1224 {
    public static void main(String[] args) {

    }

    public int maxEqualFreq(int[] nums) {
        int[] cnts = new int[100005], freq = new int[100005]; // 记录每个数的出现次数，记录每种次数出现频率
        int ans = 1, n = nums.length, max = 0, min = 0, type = 0; // 最大次数，最小次数
        for (int i = 0; i < n; i++) {
            cnts[nums[i]]++;
            if (++freq[cnts[nums[i]]] == 1) type++;
            if (freq[cnts[nums[i]] - 1] > 0) freq[cnts[nums[i]] - 1]--;
            if (cnts[nums[i]] > 1 && freq[cnts[nums[i]] - 1] == 0) type--;
            if (cnts[nums[i]] == 1) min = 1;
            else if (cnts[nums[i]] - 1 == min && freq[cnts[nums[i]] - 1] == 0) min++;
            if (cnts[nums[i]] > max) max++;
            // 1、所有数频率都是1；2、就出现过一种数字;3、有两种频率，其中一种是1且出现一次；4、两种频率，较大的出现1次，且最大最小值相邻;
            if ((type == 1 && (max == 1 || freq[max] == 1)) ||
                    (type == 2 && ((min == 1 && freq[min] == 1) || (max - min == 1 && freq[max] == 1)))) ans = i + 1;
        }
        return ans;
    }

    public int maxEqualFreqMap(int[] nums) {
        int[] cnt = new int[100005];
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 1, n = nums.length;
        for (int i = 0; i < n; i++) {
            int prev = map.getOrDefault(cnt[nums[i]], 0);
            cnt[nums[i]]++;
            map.put(cnt[nums[i]], map.getOrDefault(cnt[nums[i]], 0) + 1);
            if (prev > 0) {
                map.put(cnt[nums[i]] - 1, prev - 1);
                if (prev == 1) map.remove(cnt[nums[i]] - 1);
            }
            if (map.size() <= 2) {
                Map.Entry<Integer, Integer>[] entries = map.entrySet().toArray(new Map.Entry[0]);
                if (map.size() == 1) {
                    if (map.containsKey(1) || entries[0].getValue() == 1) ans = i + 1;
                }
                else {
                    if (map.containsKey(1) && map.get(1) == 1) ans = i + 1;
                    else if (Math.abs(entries[0].getKey() - entries[1].getKey()) == 1 &&
                            map.get(Math.max(entries[0].getKey(), entries[1].getKey())) == 1) ans = i + 1;
                }
            }
        }
        return ans;
    }
}
