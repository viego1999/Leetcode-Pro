package ojs.luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * STA-Station
 * <p>
 * 题目描述
 * 给定一个 n 个点的树，请求出一个结点，使得以这个结点为根时，所有结点的深度之和最大。一个结点的深度之定义为该节点到根的简单路径上边的数量。
 */
public class P3478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");
    static int N = (int) 1e6 + 5, n;
    static long[] dp = new long[N], sz = new long[N]; // dpi-表示以i为根时所有节点的深度之和，szi-表示以i为根的子树中的节点个数
    static long[] dep = new long[N]; // depi-节点i的深度
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        n = nextInt();
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int u = nextInt(), v = nextInt();
            adjs[u].add(v);
            adjs[v].add(u);
        }
        dfs1(1, 1);
        for (int i = 1; i <= n; i++) dp[1] += dep[i];
        dfs2(1, 1);
        long ans = -1;
        int idx = 0;
        for (int i = 1; i <= n; i++) { // 统计答案
            if (dp[i] > ans) {
                ans = dp[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }

    // 预处理 dfs - 得到以某个节点为根时，其子树中的节点总数
    public static void dfs1(int u, int fa) {
        sz[u] = 1;
        dep[u] = dep[fa] + 1;
        for (int v : adjs[u]) {
            if (v != fa) {
                dfs1(v, u);
                sz[u] += sz[v];
            }
        }
    }

    // 换根dp
    public static void dfs2(int u, int fa) {
        for (int v : adjs[u]) {
            if (v != fa) {
                // 所有在 v 的子树上的结点深度都减少了一，那么总深度和就减少了 sv；
                // 所有不在 v 的子树上的结点深度都增加了一，那么总深度和就增加了 n - sv；
                // dp[v] = dp[u] - s[v] * 1 + (n - s[v]) * 1
                dp[v] = dp[u] - sz[v] * 2 + n;
                dfs2(v, u);
            }
        }
    }

    public static String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() { return Integer.parseInt(next()); }

    public static long nextLong() { return Long.parseLong(next()); }

}
