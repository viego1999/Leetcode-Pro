package problems;

import com.sun.istack.internal.NotNull;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *
 *
 * 示例1：
 *
 *
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 *
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 *
 * link: https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class Problem515 {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(max);
        }
        return ans;
    }

    public List<Integer> largestValues_(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode node, int level, @NotNull List<Integer> ans) {
        if (node == null) return;
        if (level == ans.size()) ans.add(node.val);
        else ans.set(level, Math.max(node.val, ans.get(level)));
        dfs(node.left, level + 1, ans);
        dfs(node.right, level + 1, ans);
    }
}
