package ojs.luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Bob 喜欢玩电脑游戏，特别是战略游戏。但是他经常无法找到快速玩过游戏的办法。现在他有个问题。
 * <p>
 * 题目描述
 * 他要建立一个古城堡，城堡中的路形成一棵无根树。他要在这棵树的结点上放置最少数目的士兵，使得这些士兵能瞭望到所有的路。
 * 注意，某个士兵在一个结点上时，与该结点相连的所有边将都可以被瞭望到。请你编一程序，给定一树，帮 Bob 计算出他需要放置最少的士兵。
 */
public class P2016 {

    static int[][] dp;
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), root = -1;
        adjs = new ArrayList[n];
        dp = new int[n][2]; // dp[i][j] - 表示在节点i处，（0-不放置士兵，1-放置士兵）时监控到所有节点需要的最少士兵数目
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = scan.nextInt(), k = scan.nextInt();
            for (int j = 0; j < k; j++) {
                int v = scan.nextInt();
                adjs[u].add(v);
                degrees[v]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.min(dp[root][0], dp[root][1]));
    }

    public static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = 1;
        for (int v : adjs[u]) {
            dfs(v);
            dp[u][0] += dp[v][1]; // 如果当前节点不放置士兵,那么它的子节点必须全部放置士兵,因为要满足士兵可以看到所有的边
            dp[u][1] += Math.min(dp[v][0], dp[v][1]);
        }
    }
}
