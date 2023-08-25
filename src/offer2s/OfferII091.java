package offer2s;

import java.util.Arrays;

/**
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 *
 *
 * 示例 1：
 *
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 *
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 *
 *
 * 提示:
 *
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 *
 * link: https://leetcode.cn/problems/JEj789/
 */
public class OfferII091 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
    }

    public int minCost__(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i - 1][j];
            }
        }
        return Arrays.stream(dp[n]).min().getAsInt();
    }

    public static int minCost(int[][] costs) {
        int a = costs[0][0], b = costs[0][1], c = costs[0][2], n = costs.length;
        for (int i = 1; i < n; i++) {
            int la = a, lb = b;
            a = Math.min(b, c) + costs[i][0];
            b = Math.min(la, c) + costs[i][1];
            c = Math.min(la, lb) + costs[i][2];
        }
        return Math.min(a, Math.min(b, c));
    }

    public static int minCost_(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
