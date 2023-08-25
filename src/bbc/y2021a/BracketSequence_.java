package bbc.y2021a;

import java.util.*;

/**
 * 题目描述
 * <p>
 * 给定一个括号序列，要求尽可能少地添加若干括号使得括号序列变得合法。
 * <p>
 * 当添加完成后，会产生不同的添加结果，请问有多少种本质不同的添加结果。
 * <p>
 * 两个结果是本质不同的是指存在某个位置一个结果是左括号，而另一个是右括号。
 * <p>
 * 例如，对于括号序列((()，只需要添加两个括号就能让其合法
 * <p>
 * 有以下几种不同的添加结果：()()()、()(())、(())()、(()()) 和((()))。
 * <p>
 * 输入格式
 * <p>
 * 输入一行包含一个字符串s，表示给定的括号序列，序列中只有左括号和右括号。
 * <p>
 * 对于40% 的评测用例，|s| ≤ 200。
 * <p>
 * 对于所有评测用例，1 ≤ |s| ≤ 5000。
 * <p>
 * 输出格式
 * <p>
 * 输出一个整数表示答案，答案可能很大，请输出答案除以1000000007
 * <p>
 * 输入样例 复制
 * <p>
 * ((()
 * <p>
 * 输出样例 复制
 * <p>
 * 5
 */
public class BracketSequence_ {
    static int N = (int) 5e3 + 5, n;
    static int[][] dp = new int[N][N]; // dp[i][j]：前i个括号，座比右多j个的方案数
    static int mod = (int) 1e9 + 7;
    static char[] a;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        a = scan.nextLine().toCharArray();
        n = a.length;
        long l = calc();
        int i = 0, j = n - 1;
        while (i <= j) {
            if (a[i] == '(') a[i] = ')';
            else a[i] = '(';
            if (i != j) {
                if (a[j] == '(') a[j] = ')';
                else a[j] = '(';
            }
            char c = a[i];
            a[i++] = a[j];
            a[j--] = c;
        }
        long r = calc();
        System.out.println(l * r % mod);
    }

    /*
     * dp[i][j]：前i个括号，座比右多j个的方案数
     *      a[i]='(', dp(i,j)=dp(i-1,j-1)
     *      a[i]=')', dp(i,j)=Σk={0,j+1} dp(i-1,k)
     *      dp(i,j-1)=Σk={0,j}dp(i-1,k)所以 dp(i,j)=dp(i-1,j+1)+dp(i,j-1).
     */
    public static long calc() {
        for (int[] ints : dp) Arrays.fill(ints, 0);
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            if (a[i  -1] == '(') {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            } else {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i][j - 1]) % mod;
                }
            }
        }
        for (int i = 0; i <= n; i++) if (dp[n][i] != 0) return dp[n][i];
        return -1;
    }
}
