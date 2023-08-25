package bbc.y2021f;

import java.util.Scanner;

/**
 * 题目 2615: 蓝桥杯2021年第十二届国赛真题-翻转括号序列
 * <p>
 * 时间限制: 1Sec 内存限制: 128MB 提交: 523 解决: 43
 * <p>
 * 题目描述
 * <p>
 * 给定一个长度为 n 的括号序列，要求支持两种操作：
 * <p>
 * 1. 将 [Li, Ri] 区间内（序列中的第 Li 个字符到第 Ri 个字符）的括号全部翻转（左括号变成右括号，右括号变成左括号）。
 * <p>
 * 2. 求出以 Li 为左端点时，最长的合法括号序列对应的 Ri （即找出最大的Ri 使 [Li, Ri] 是一个合法括号序列）。
 * <p>
 * 输入
 * <p>
 * 输入的第一行包含两个整数 n, m，分别表示括号序列长度和操作次数。
 * <p>
 * 第二行包含给定的括号序列，括号序列中只包含左括号和右括号。
 * <p>
 * 接下来 m 行，每行描述一个操作。如果该行为 “1 Li Ri”，表示第一种操作，区间为 [Li, Ri] ；如果该行为 “2 Li” 表示第二种操作，左端点为 Li。
 * <p>
 * 输出
 * <p>
 * 对于每个第二种操作，输出一行，表示对应的 Ri。如果不存在这样的 Ri，请输出 0。
 * <p>
 * 样例输入
 * <p>
 * 7 5
 * <p>
 * ((())()
 * <p>
 * 2 3
 * <p>
 * 2 2
 * <p>
 * 1 3 5
 * <p>
 * 2 3
 * <p>
 * 2 1
 * <p>
 * 样例输出
 * <p>
 * 4
 * <p>
 * 7
 * <p>
 * 0
 * <p>
 * 0
 * <p>
 * 提示
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 20% 的评测用例，n, m ≤ 5000；
 * <p>
 * 对于 40% 的评测用例，n, m ≤ 30000；
 * <p>
 * 对于 60% 的评测用例，n, m ≤ 100000；
 * <p>
 * 对于所有评测用例，1 ≤ n ≤ 10^6, 1 ≤ m ≤ 2 × 10^5。
 */
public class FlipBracketSequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        char[] cs = scan.next().toCharArray();
        while (m-- > 0) {
            int o = scan.nextInt(), l = scan.nextInt() - 1;
            if (o == 1) {
                int r = scan.nextInt() - 1;
                reverse(cs, l, r);
            } else {
                System.out.println(solve(cs, l) + 1);
            }
        }
    }

    public static void reverse(char[] cs, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (cs[i] == '(') cs[i] = ')';
            else cs[i] = '(';
        }
    }

    public static int solve(char[] cs, int l) {
        int n = cs.length, ls = 0, ans = -1;
        for (int i = l; i < n && ls <= n - i; i++) {
            if (cs[i] == '(') ls++;
            else {
                if (ls == 0) return ans; // 左括号全部抵消，右括号更多，已经不合法了
                else {
                    if (--ls == 0) ans = i; // 左右括号全部抵消，更新长度 ans
                }
            }
        }
        return ans;
    }

    public static int dp(char[] cs) { // 最长有效括号序列
        int m = cs.length, ans = 0;
        int[] dp = new int[m];
        for (int i = 1; i < m; i++) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') dp[i] = (i >= 2 ? dp[i - 1] : 0) + 2;
                else {
                    int j = i - dp[i - 1] - 1;
                    if (j >= 0 && cs[j] == '(')
                        dp[i] = dp[i - 1] + 2 + (j > 0 ? dp[j - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
