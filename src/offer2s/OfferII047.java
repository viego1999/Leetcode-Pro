package offer2s;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII047
 * @since 2023/5/1 23:30
 */
public class OfferII047 {
    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }
}
