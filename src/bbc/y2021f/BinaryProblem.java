package bbc.y2021f;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目 2619: 蓝桥杯2021年第十二届国赛真题-二进制问题
 * <p>
 * 时间限制: 1Sec 内存限制: 128MB 提交: 1825 解决: 274
 * <p>
 * 题目描述
 * <p>
 * 小蓝最近在学习二进制。他想知道 1 到 N 中有多少个数满足其二进制表示中恰好有 K 个 1。你能帮助他吗？
 * <p>
 * 输入
 * <p>
 * 输入一行包含两个整数 N 和 K。
 * <p>
 * 输出
 * <p>
 * 输出一个整数表示答案。
 * <p>
 * 样例输入
 * <p>
 * 7 2
 * <p>
 * 样例输出
 * <p>
 * 3
 * <p>
 * 提示
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 30% 的评测用例，1 ≤ N ≤ 10^6, 1 ≤ K ≤ 10。
 * <p>
 * 对于 60% 的评测用例，1 ≤ N ≤ 2 × 10^9, 1 ≤ K ≤ 30。
 * <p>
 * 对于所有评测用例，1 ≤ N ≤ 10^18, 1 ≤ K ≤ 50。
 */
public class BinaryProblem {
    static int N = 105, K;
    static int[] arr = new int[N];
    static long[][] dp = new long[N][N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong(); K = scan.nextInt();
        System.out.println(solve(N));
    }

    public static long solve(long n) {
        for (long[] ints : dp) Arrays.fill(ints, -1);
        int pos = 0;
        while (n != 0) {
            arr[++pos] = (int) (n & 1);
            n >>= 1;
        }
        return dfs(pos, 0, true);
    }

    public static long dfs(int pos, int cnt, boolean limit) {
        if (pos == 0) return cnt == K ? 1 : 0;
        if (dp[pos][cnt] != -1 && !limit) return dp[pos][cnt];
        long res = 0; int up = limit ? arr[pos] : 1;
        for (int i = 0; i <= up; i++) {
            int t = cnt;
            if (i == 1) t++;
            res += dfs(pos - 1, t, i == up && limit);
        }
        if (!limit) dp[pos][cnt] = res;
        return res;
    }
}
