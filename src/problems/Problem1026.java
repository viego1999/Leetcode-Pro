package problems;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1026
 * @since 2023/4/18 20:52
 */
public class Problem1026 {
    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode node, int min, int max) {
        if (node == null) return 0;
        int diff = Math.max(Math.abs(min - node.val), Math.abs(max - node.val));
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        return Math.max(diff, Math.max(dfs(node.left, min, max), dfs(node.right, min, max)));
    }

    int ans = 0;

    public int maxAncestorDiff_(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode node) {
        int[] lefts = node.left == null ? new int[]{node.val, node.val} : dfs(node.left);
        int[] rights = node.right == null ? new int[]{node.val, node.val} : dfs(node.right);
        int[] arr = new int[]{Math.min(lefts[0], rights[0]), Math.max(lefts[1], rights[1])};
        ans = Math.max(ans, Math.max(Math.abs(arr[1] - node.val), Math.abs(arr[0] - node.val)));
        return new int[]{Math.min(node.val, arr[0]), Math.max(node.val, arr[1])};
    }
}
