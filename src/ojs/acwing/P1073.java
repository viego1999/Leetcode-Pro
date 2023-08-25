package ojs.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P1073. 树的中心
 * <p>
 * 给定一棵树，树中包含n个结点 (编号1n)和n-1条无向边，每条边都有一个权值请你在树中找到一个点，使得该点到树中其他结点的最远距离最近。
 * <p>
 * 5
 * <p>
 * 2 1 1
 * <p>
 * 3 2 1
 * <p>
 * 4 3 1
 * <p>
 * 5 1 1
 *
 * <p>
 * 2
 */
public class P1073 {
    static int N = (int) 1e4 + 5;
    // dp[i][0] - 向下的最长距离，dp[i][1] - 向下的次长距离，dp[i][2] - 向上的最长距离（走父节点）
    static int[][] dp = new int[N][3];
    static int[] sons = new int[N]; // sons[u] = v 表示 u 为父节点得到最大距离的子节点为 v
    static List<int[]>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            adjs[u].add(new int[]{v, w});
            adjs[v].add(new int[]{u, w});
        }
        dfs1(1, 1);
        dfs2(1, 1);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) ans = Math.min(ans, Math.max(dp[i][0], dp[i][2]));
        System.out.println(ans);
    }

    // 求最长和次长 dp[i][0], dp[i][1]
    public static void dfs1(int u, int fa) {
        dp[u][0] = dp[u][1] = 0;
        for (int[] vw : adjs[u]) {
            int v = vw[0], w = vw[1];
            if (v == fa) continue;
            dfs1(v, u);
            if (dp[u][0] < dp[v][0] + w) {
                dp[u][1] = dp[u][0];
                dp[u][0] = dp[v][0] + w;
                sons[u] = v;
            } else dp[u][1] = Math.max(dp[u][1], dp[v][0] + w);
        }
    }

    // 更新从父节点出发的最长路径
    public static void dfs2(int u, int fa) {
        for (int[] vw : adjs[u]) {
            int v = vw[0], w = vw[1];
            if (v == fa) continue;
            if (v == sons[u]) dp[v][2] = Math.max(dp[u][1], dp[u][2]) + w;
            else dp[v][2] = Math.max(dp[u][0], dp[u][2]) + w;
            dfs2(v, u);
        }
    }
}
