package offer2s;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII052
 * @since 2023/5/2 18:37
 */
public class OfferII052 {
    public static void main(String[] args) {

    }

    TreeNode dummy = new TreeNode(-1), p = dummy;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return dummy.right;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        p.right = node;
        node.left = null;
        p = p.right;
        dfs(node.right);
    }
}
