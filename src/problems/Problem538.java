package problems;

import util.TreeNode;

public class Problem538 {

    int cnt = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        cnt += root.val;
        root.val = cnt;
        convertBST(root.left);
        return root;
    }
}
