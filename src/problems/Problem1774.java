package problems;

public class Problem1774 {
    public static void main(String[] args) {

    }

    int ans = 0x3f3f3f3f;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            dfs(toppingCosts, 0, baseCost, target);
        }
        return ans;
    }

    public void dfs(int[] ts, int idx, int sum, int target) {
        int a = Math.abs(ans - target), b = Math.abs(sum - target);
        if (a > b) ans = sum;
        if (a == b) ans = Math.min(ans, sum);
        if (sum > target) return;
        for (int i = idx; i < ts.length; i++) {
            dfs(ts, i + 1, sum + ts[i], target);
            dfs(ts, i + 1, sum + 2 * ts[i], target);
        }
    }
}
