package problems;

import util.TreeNode;

public class Problem543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int ld = dfs(root.left), rd = dfs(root.right);
        ans = Math.max(ans, ld + rd + 1);
        return 1 + Math.max(ld, rd);
    }
}
