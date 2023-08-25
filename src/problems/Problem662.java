package problems;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 *
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 *
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 *
 *
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 *
 *
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 *
 * link: https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class Problem662 {
    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int ans = 0;
        q1.offer(root);
        q2.offer(0);
        while (!q1.isEmpty()) {
            int size = q1.size(), a = 0, b = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q1.poll();
                int f = q2.poll();
                if (curr.left != null) {
                    q1.offer(curr.left);
                    q2.offer(2 * f + 1);
                }
                if (curr.right != null) {
                    q1.offer(curr.right);
                    q2.offer(2 * f + 2);
                }
                if (i == 0) a = f;
                if (i == size - 1) b = f;
            }
            ans = Math.max(ans, b - a + 1);
        }
        return ans;
    }
}
