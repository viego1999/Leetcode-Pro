package problems;

import util.TreeNode;

import java.util.*;

/**
 * 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 *  ["2","",""]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]]
 *
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 *
 * link: https://leetcode.cn/problems/print-binary-tree/
 */
public class Problem655 {
    public static void main(String[] args) {

    }

    public List<List<String>> printTree(TreeNode root) {
        int m = getHeight(root), n = (1 << m) - 1;
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            ans.add(list);
        }
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();
        q1.offer(root);
        q2.offer(new int[]{0, (n - 1) / 2});
        ans.get(0).set((n - 1) / 2, String.valueOf(root.val));
        while (!q1.isEmpty()) {
            TreeNode cur = q1.poll();
            int[] ij = q2.poll();
            if (cur.left != null) {
                q1.offer(cur.left);
                q2.offer(new int[]{ij[0] + 1, ij[1] - (1 << (m - ij[0] - 2))});
                ans.get(ij[0] + 1).set(ij[1] - (1 << (m - ij[0] - 2)), String.valueOf(cur.left.val));
            }
            if (cur.right != null) {
                q1.offer(cur.right);
                q2.offer(new int[]{ij[0] + 1, ij[1] + (1 << (m - ij[0] - 2))});
                ans.get(ij[0] + 1).set(ij[1] + (1 << (m - ij[0] - 2)), String.valueOf(cur.right.val));
            }
        }
        return ans;
    }

    List<List<String>> ans2 = new ArrayList<>();
    String[][] strs;
    int m, n;

    public List<List<String>> printTreeDfs(TreeNode root) {
        n = (1 << (m = getHeight(root))) - 1;
        strs = new String[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(strs[i], "");
        dfs(root, 0, (n - 1) / 2);
        for (int i = 0; i < m; i++) ans2.add(Arrays.asList(strs[i]));
        return ans2;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public void dfs(TreeNode node, int r, int c) {
        strs[r][c] = String.valueOf(node.val);
        if (node.left != null) dfs(node.left, r + 1, c - (1 << (m - r - 2)));
        if (node.right != null) dfs(node.right, r + 1, c + (1 << (m - r - 2)));
    }
}
