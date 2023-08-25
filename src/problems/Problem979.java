package problems;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem979
 * @since 2023/7/14 0:56
 */
public class Problem979 {
    public static void main(String[] args) {

    }

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int sum = left + right + root.val;
        ans += Math.abs(sum - 1);
        return sum - 1;
    }
}
