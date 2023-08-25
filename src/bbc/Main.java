package bbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // 此类用来复习使用
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
    static StringTokenizer tokenizer = new StringTokenizer("");
    static int N = (int) 1e5 + 5;
    static double[] dp = new double[N]; // dp[i]: 经过i的期望次数
    static List<int[]>[] edges;
    static int[] inDegrees, outDegrees;

    public static void main(String[] args) {
        int n = nextInt(), m = nextInt();
        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
        inDegrees = new int[n + 1]; outDegrees = new int[n + 1];
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            edges[a].add(new int[]{b, c});
            outDegrees[a]++;
            inDegrees[b]++;
        }
        solve();
    }

    public static void solve() {
        double ans = 0.;
        int f = 0, r = 0;
        dp[1] = 1;
        int[] queue = new int[N];
        queue[r++] = 1;
        while (r - f > 0) {
            int u = queue[f++];
            for (int[] vw : edges[u]) {
                int v = vw[0], w = vw[1];
                dp[v] += dp[u] / outDegrees[u];
                ans += dp[u] * w / (double) outDegrees[u];
                if (--inDegrees[v] == 0) queue[r++] = v;
            }
        }
        System.out.printf("%.2f", ans);
    }

    private static String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    private static long nextLong() { return Long.parseLong(next()); }
}
