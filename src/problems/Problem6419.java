package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6419
 * @since 2023/5/7 12:16
 */
public class Problem6419 {
    public static void main(String[] args) {

    }

    int ans = 0;

    public int minIncrements(int n, int[] cost) {
        dfs(1, cost);
        return ans;
    }

    public int dfs(int cur, int[] cost) {
        if (cur > cost.length) return 0;
        int left = dfs(cur * 2, cost), right = dfs(cur * 2 + 1, cost);
        ans += Math.abs(left - right);
        return Math.max(left, right) + cost[cur - 1];
    }
}
