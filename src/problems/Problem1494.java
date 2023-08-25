package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1494
 * @since 2023/6/16 14:29
 */
public class Problem1494 {
    public static void main(String[] args) {
        Problem1494 problem1494 = new Problem1494();
        System.out.println(problem1494.minNumberOfSemesters(4, new int[][]{{2, 1}, {3, 1}, {1, 4}}, 2));
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dp = new int[1 << n], degrees = new int[n];
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int[] relation : relations) {
            degrees[relation[1] - 1]++;
            adjs[relation[0] - 1].add(relation[1] - 1);
        }
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] == 0x3f3f3f3f) continue;
            int[] ds = getDegrees(i, adjs, degrees.clone());
            List<Integer> idxs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0 || ds[j] != 0) continue;
                idxs.add(j);
            }
            backtrack(idxs, dp, i, i, 0, k);
        }
        return dp[(1 << n) - 1];
    }

    public void backtrack(List<Integer> idxs, int[] dp, int i, int state, int idx, int cnt) {
        if (cnt == 0 || idx == idxs.size()) return;
        backtrack(idxs, dp, i, state, idx + 1, cnt);
        dp[state |= (1 << idxs.get(idx))] = Math.min(dp[i] + 1, dp[state]);
        backtrack(idxs, dp, i, state, idx + 1, cnt - 1);
    }

    public int[] getDegrees(int state, List<Integer>[] adjs, int[] degrees) {
        for (int i = 0; i < adjs.length; i++) {
            if (((state >> i) & 1) != 0) {
                for (int v : adjs[i]) --degrees[v];
            }
        }
        return degrees;
    }
}
