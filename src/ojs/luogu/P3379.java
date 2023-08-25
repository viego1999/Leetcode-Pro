package ojs.luogu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 最近公共祖先模板题
 * <p>
 * <a href="https://blog.csdn.net/m0_55682843/article/details/123539091">LCA最近公共祖先求解</a>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName P3379
 * @since 2023/6/12 15:37
 */
public class P3379 {
    static List<Integer>[] adjs;
    static int[] depth; // dp[i] - 表示节点i的高度
    static int[][] pa; // pa[i][j] - 表示节点i的第2^j的祖先
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt(), s = nextInt();
        adjs = new ArrayList[n + 1];
        depth = new int[n + 1];
        pa = new int[n + 1][21];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt(), v = nextInt();
            adjs[u].add(v);
            adjs[v].add(u);
        }
        dfs(s, 0);
        for (int i = 0; i < m; i++) {
            bw.write(String.valueOf(LCA(nextInt(), nextInt())));
            bw.newLine();
            bw.flush();
        }
    }

    public static void dfs(int u, int fa) {
        depth[u] = depth[fa] + 1;
        pa[u][0] = fa;
        for (int i = 1; (1 << i) <= depth[u]; i++) {
            pa[u][i] = pa[pa[u][i - 1]][i - 1];
        }
        for (int v : adjs[u]) {
            if (v != fa) {
                dfs(v, u);
            }
        }
    }

    public static int LCA(int x, int y) { // 默认 x 的深度大于 y
        if (depth[x] < depth[y]) return LCA(y, x);
        // 让 x 向上走到与 y 相等的高度
        for (int i = 20; i >= 0; i--) {
            if (depth[pa[x][i]] >= depth[y]) {
                x = pa[x][i];
            }
        }
        if (x == y) return x; // 如果 x 和 y 相等，则表明 y 是 x 的祖先节点
        // 节点 x 和节点 y 一起向上寻找父节点
        for (int i = 20; i >= 0; i--) {
            if (pa[x][i] != pa[y][i]) {
                x = pa[x][i];
                y = pa[y][i];
            }
        }
        return pa[x][0];
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
}
