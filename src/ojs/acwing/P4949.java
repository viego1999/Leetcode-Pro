package ojs.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P4949 {
    static int N = (int) 1e5 + 5;
    static int[][] dp = new int[N][2];
    static List<Integer>[] adjs;
    static int[] degrees = new int[N], colors = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            colors[i] = scan.nextInt();
            dp[i][0] = dp[i][1] = colors[i];
        }
        for (int i = 0; i < n -1; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            adjs[u].add(v);
            adjs[v].add(u);
            degrees[u]++;
            degrees[v]++;
        }
        dfs(1, 1);
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (degrees[i] == 1 && dp[i][1] <= m) ans++;
        }
        System.out.println(ans);
    }

    public static void dfs(int u, int fa) {
        for (int v : adjs[u]) {
            if (v == fa) continue;
            dp[v][0] = colors[v] == 0 ? 0 : 1 + dp[u][0];
            dp[v][1] = Math.max(dp[u][1], dp[v][0]);
            dfs(v, u);
        }
    }
}
