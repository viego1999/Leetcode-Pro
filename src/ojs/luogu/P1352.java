package ojs.luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 洛谷 P1352 没有上司的舞会
 * <p>
 * 某大学有 n 个职员，编号为 1 \sim N。他们之间有从属关系，也就是说他们的关系就像一棵以校长为根的树，父结点就是子结点的直接上司。
 * 现在有个周年庆宴会，宴会每邀请来一个职员都会增加一定的快乐指数 a_i，但是呢，如果某个职员的直接上司来参加舞会了，那么这个职员就无
 * 论如何也不肯来参加舞会了。所以，请你编程计算，邀请哪些职员可以使快乐指数最大，求最大的快乐指数。
 */
public class P1352 {
    static int N = 6005;
    static int[][] dp = new int[N][2]; // dp[i][j] 表示以i为根节点，0-表示当前节点不参加，1-表示当前节点参加
    static int[] scores = new int[N], degrees = new int[N];
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) scores[i] = scan.nextInt();
        adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int v = scan.nextInt(), u = scan.nextInt();
            adjs[u].add(v);
            degrees[v]++;
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.max(dp[root][0], dp[root][1]));
    }

    public static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = scores[u];
        for (int v : adjs[u]) {
            dfs(v);
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
            dp[u][1] += dp[v][0];
        }
    }
}
