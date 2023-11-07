package problems;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1448
 * @since 2023/8/25 21:54
 */
public class Problem1448 {
    public static void main(String[] args) {

    }

    int ans = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, -0x3f3f3f3f);
        return ans;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            max = root.val;
            ans++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
