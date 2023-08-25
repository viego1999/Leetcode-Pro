package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 *
 *
 * 示例 1：
 *
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 *
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 *
 * link: https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
public class Problem873 {
    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(lenLongestFibSubseq(new int[]{2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 5, 6, 7, 13}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 5}));
    }

    // 1 2 3 5 8
    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length, ans = 0;
        int[][] dp = new int[n][n]; // dp[i][j]表示以arr[i]arr[j]作为倒数两个数的最长长度
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        for (int j = 2; j < n; j++) { // 最后一个数
            for (int i = j - 1; i > 0 && arr[i] * 2 > arr[j]; i--) { // 第二大数（剪枝：2*第二大数一定大最大数）
                int a = map.getOrDefault(arr[j] - arr[i], j); // 第三大数
                if (a < i) { // 第三大数在第二大数前面
                    dp[i][j] = dp[a][i] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans == 0 ? 0 : ans + 2;
    }

    public static int lenLongestFibSubseq_(int[] arr) {
        int ans = 0, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j], sum = a + b, cnt = 0;
                while (Arrays.binarySearch(arr, sum) > 0) {
                    a = b;
                    b = sum;
                    sum = a + b;
                    cnt++;
                }
                ans = Math.max(cnt, ans);
            }
        }
        return ans == 0 ? 0 : ans + 2;
    }
}
