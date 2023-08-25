package ojs.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P1072.树的最长路径
 * <p>
 * 给定一棵树，树中包含n个结点 (编号1~n)和n-1条无向边，每条边都有一个权值现在请你找到树中的一条最长路径
 * 换句话说，要找到一条路径，使得使得路径两端的点的距离最远注意:路径中可以只包含一个点。
 * <p>
 * 6
 * <p>
 * 5 1 6
 * <p>
 * 1 4 5
 * <p>
 * 6 3 9
 * <p>
 * 2 6 8
 * <p>
 * 6 1 7
 *
 * <p>
 * 22
 * <p>
 * <a href="https://blog.csdn.net/Jacob0824/article/details/123693835">P1072.树的最长路径</a>
 */
public class P1072 {
    static int N = (int) 1e4 + 5;
    static int[][] dp = new int[N][2]; // dp[i][0] - 最长路，dp[i][1] - 次长路
    static List<int[]>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), ans = -1;
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            adjs[u].add(new int[]{v, w});
            adjs[v].add(new int[]{u, w});
        }
        dfs(1, 1);
        for (int i = 1; i <= n; i++) ans = Math.max(ans, dp[i][0] + dp[i][1]);
        System.out.println(ans);
    }

    public static void dfs(int u, int fa) {
        dp[u][0] = dp[u][1] = 0;
        for (int[] vw : adjs[u]) {
            int v = vw[0], w = vw[1];
            if (v == fa) continue;
            dfs(v, u);
            if (dp[u][0] <= dp[v][0] + w) { // 更新最长距离
                // 先更新次长距离
                dp[u][1] = dp[u][0];
                // 在更新最长距离
                dp[u][0] = dp[v][0] + w;
            } else dp[u][1] = Math.max(dp[u][1], dp[v][0] + w);
        }
    }
}
