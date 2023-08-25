package problems;

import util.TreeNode;

import java.util.Arrays;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个
 * “父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 链接：<a href="https://leetcode-cn.com/problems/house-robber-iii/">打家劫舍III</a>
 */
public class Problem337 {
    public static void main(String[] args) {
        System.out.println(rob(TreeNode.createBinaryTree(Arrays.asList(3, 2, null, 3, null, null, 3, null, 1))));
    }

    public static int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]); // status0 is selected, status1 is don't selected.
    }

    public static int[] dfs(TreeNode node) { // 树形DP入门
        if (node == null) return new int[]{0, 0};
        int[] lefts = dfs(node.left), rights = dfs(node.right);
        int selected = node.val + lefts[1] + rights[1];
        int noSelected = Math.max(lefts[0], lefts[1]) + Math.max(rights[0], rights[1]);
        return new int[]{selected, noSelected};
    }
}
