package problems;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1080
 * @since 2023/5/22 11:09
 */
public class Problem1080 {
    public static void main(String[] args) {

    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit) < limit ? null : root;
    }

    public int dfs(TreeNode node, int prev, int limit) {
        if (node == null) return -0x3f3f3f3f;
        if (node.left == null && node.right == null) return node.val + prev;
        int left = dfs(node.left, node.val + prev, limit), right = dfs(node.right, node.val + prev, limit);
        if (left < limit) node.left = null;
        if (right < limit) node.right = null;
        return Math.max(left, right);
    }
}
