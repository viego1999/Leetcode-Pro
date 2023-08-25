package ojs.luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CTSC1997 选课
 * <p>
 * 在大学里每个学生，为了达到一定的学分，必须从很多课程里选择一些课程来学习，在课程里有些课程必须在某些课程之前学习，如高等数学总是在其它课程之前学习。现在有
 * �
 * N 门功课，每门课有个学分，每门课有一门或没有直接先修课（若课程 a 是课程 b 的先修课即只有学完了课程 a，才能学习课程 b）。一个学生要从这些课程里选择
 * �
 * M 门课程学习，问他能获得的最大学分是多少？
 */
public class P2014 {
    static int[][] dp; // dp[i][j] - 以i为根节点选了j门课程的最大学分
    static int n, m;
    static int[] scores;
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        dp = new int[n + 5][n + 5];
        scores = new int[n + 5];
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int u = scan.nextInt(), score = scan.nextInt();
            adjs[u].add(i);
            scores[i] = score;
        }
        // 新增一门0学分的课程0，作为所有无先修课课程的先修课
        dfs(0);
        System.out.println(dp[0][m + 1]);
    }

    public static void dfs(int u) {
        dp[u][1] = scores[u];
        for (int v : adjs[u]) {
            dfs(v);
            // 注意下面两重循环的上界和下界
            // 只考虑已经合并过的子树，以及选的课程数超过 m+1 的状态没有意义
            for (int j = m + 1; j >= 1; --j) { // 背包重量
                for (int k = 0; k < j; k++) { // k < j，必须保证选 curr，才能往下选择其子节点
                    dp[u][j] = Math.max(dp[u][j], dp[v][k] + dp[u][j - k]);
                }
            }
        }
    }
}
