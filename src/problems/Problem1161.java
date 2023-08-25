package problems;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 *
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *
 *
 * 提示：
 *
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 *
 * link: https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 */
public class Problem1161 {
    public static void main(String[] args) {

    }

    int[] hash = new int[10005];
    int ans = 0, max = Integer.MIN_VALUE, n;

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        for (int i = 0; i <= n; i++) {
            if (hash[i] > max) {
                max = hash[ans = i];
            }
        }
        return ans + 1;
    }

    public void dfs(TreeNode node, int level) {
        hash[level] += node.val;
        n = Math.max(n, level);
        if (node.left != null) dfs(node.left, level + 1);
        if (node.right != null) dfs(node.right, level + 1);
    }

    public int maxLevelSumBfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0, level = 1, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (max < sum) {
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
