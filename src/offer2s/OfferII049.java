package offer2s;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII049
 * @since 2023/5/2 15:38
 */
public class OfferII049 {
    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int cur) {
        if (node == null) return 0;
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) return cur;
        else return dfs(node.left, cur) + dfs(node.right, cur);
    }
}
