package problems;

import util.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 *
 *
 *
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 *
 *
 * 提示:
 *
 * 树的节点数的范围是 [0, 104]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 *
 * link: https://leetcode.cn/problems/longest-univalue-path/
 */
public class Problem687 {
    public static void main(String[] args) {

    }

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right), left = 0, right = 0;
        if (node.left != null && node.left.val == node.val) left = 1 + l;
        if (node.right != null && node.right.val == node.val) right = 1 + r;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
