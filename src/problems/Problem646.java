package problems;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * link: https://leetcode.cn/problems/maximum-length-of-pair-chain/
 */
public class Problem646 {
    public static void main(String[] args) {

    }

    public int findLongestChainDp(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> x[0] - y[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1] + 1;
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> x[1] - y[1]);
        int ans = 0, curr = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
