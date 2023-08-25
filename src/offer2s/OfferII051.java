package offer2s;

import util.TreeNode;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII051
 * @since 2023/5/2 19:13
 */
public class OfferII051 {
    public static void main(String[] args) {

    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0), right = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum2(TreeNode root) {
        dfs2(root);
        return max;
    }

    public int[] dfs2(TreeNode root) {
        if (root == null) return new int[3];
        int[] ans = new int[3], lefts = dfs2(root.left), rights = dfs2(root.right);
        int left = Math.max(lefts[0], lefts[2]), right = Math.max(rights[0], rights[2]);
        ans[0] = root.val + Math.max(0, left);
        ans[1] = root.val + Math.max(0, left) + Math.max(0, right);
        ans[2] = root.val + Math.max(0, right);
        max = Math.max(max, Math.max(ans[0], Math.max(ans[1], ans[2])));
        return ans;
    }
}
