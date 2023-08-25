package ojs.hdoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Computer
 * <p>
 * A school bought the first computer some time ago(so this computer's id is 1). During the recent years the school
 * bought N-1 new computers. Each new computer was connected to one of settled earlier. Managers of school are anxious
 * about slow functioning of the net and want to know the maximum distance Si for which i-th computer needs to send
 * signal (i.e. length of cable to the most distant computer). You need to provide this information.
 * <p>
 *     <a href="https://blog.csdn.net/qq_39641976/article/details/109345869">2196.Computer</a>
 * </p>
 */
public class P2196 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");
    static int N = (int) 1e5 + 5;
    // dp[i][0],dp[i][1] - 表示 u 到 u 的子树中的最大距离和次大距离，dp[i][2]表示其父节点的不经过该节点的最长纪录
    static int[][] dp = new int[N][3];
    static int[] sons = new int[N];
    static List<int[]>[] adjs;

    public static void main(String[] args) {
        int n;
        while ((n = nextInt()) > 0) {
            adjs = new ArrayList[n + 5];
            for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                int v = nextInt(), dis = nextInt();
                adjs[i].add(new int[]{v, dis});
                adjs[v].add(new int[]{i, dis});
            }
            dfs1(1, 1);
            dfs2(1, 1);
            for (int i = 1; i <= n; i++) {
                System.out.println(Math.max(dp[i][0], dp[i][2]));
            }
        }
    }

    public static void dfs1(int u, int fa) { // 处理 dp[u][0], dp[u][1]
        dp[u][0] = dp[u][1] = dp[u][2] = 0;
        for (int[] vd : adjs[u]) {
            int v = vd[0], dis = vd[1];
            if (v == fa) continue;
            dfs1(v, u);
            if (dp[u][0] < dp[v][0] + dis) { // 如果发现更优的最大值则更新
                dp[u][1] = dp[u][0];
                dp[u][0] = dp[v][0] + dis;
                sons[u] = v; // u 的正向最大距离要经过儿子节点v
            } else { // 否则更新次大值
                dp[u][1] = Math.max(dp[u][1], dp[v][0] + dis);
            }
        }
    }

    public static void dfs2(int u, int fa) { // 处理 dp[u][2]
        for (int[] vd : adjs[u]) {
            int v = vd[0], dis = vd[1];
            if (v == fa) continue;
            if (sons[u] == v) dp[v][2] = Math.max(dp[u][1], dp[u][2]) + dis;
            else dp[v][2] = Math.max(dp[u][0], dp[u][2]) + dis;
            dfs2(v, u);
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
