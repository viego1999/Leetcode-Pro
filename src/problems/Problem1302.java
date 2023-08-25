package problems;

import util.TreeNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Handler;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 *
 * link: https://leetcode.cn/problems/deepest-leaves-sum/
 */
public class Problem1302 {
    public static void main(String[] args) {

    }

    int[] tree = new int[(int) 1e4 + 5];
    int h = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return tree[h];
    }

    public void dfs(TreeNode node, int level) {
        tree[level] += node.val;
        h = Math.max(h, level);
        if (node.left != null) dfs(node.left, level + 1);
        if (node.right != null) dfs(node.right, level + 1);
    }
}
