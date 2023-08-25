package offer2s;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII053
 * @since 2023/5/2 20:56
 */
public class OfferII053 {
    public static void main(String[] args) {

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null, curr = root;
        while (curr != null) {
            if (curr.val > p.val) {
                ans = curr;
                curr = curr.left;
            } else curr = curr.right;
        }
        return ans;
    }

    TreeNode ans = null;
    boolean flag = false;

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) return;
        dfs(root.left, p);
        if (flag && ans == null) ans = root;
        else {
            flag = root.val == p.val;
            dfs(root.right, p);
        }
    }
}
