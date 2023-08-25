package problems;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem236
 * @since 2023/4/8 16:02
 */
public class Problem236 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
