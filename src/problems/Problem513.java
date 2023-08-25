package problems;

import util.TreeNode;

public class Problem513 {
    public static void main(String[] args) {

    }

    public int findBottomLeftValue_(TreeNode root) {
        TreeNode[] queue = new TreeNode[(int)1e4 + 5];
        int f = 0, r = 0, ans = 0;
        queue[r++] = root;
        while (r - f > 0) {
            TreeNode node = queue[f++];
            if (node.right != null) queue[r++] = node.right;
            if (node.left != null) queue[r++] = node.left;
            ans = node.val;
        }
        return ans;
    }

    int curLevel = 0, ans;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > curLevel) {
            curLevel = level;
            ans = node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
