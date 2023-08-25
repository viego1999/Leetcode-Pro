package problems;

import util.TreeNode;

public class Problem222 {
    public static void main(String[] args) {

    }

    public int countNodesNone(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        while (root != null) {
            int lh = getHeight(root.left), rh = getHeight(root.right);
            if (lh > rh) {
                ans += (1 << rh);
                root = root.left;
            } else {
                ans += (1 << lh);
                root = root.right;
            }
        }
        return ans;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = getHeight(root.left), rh = getHeight(root.right);
        if (lh > rh) return (1 << rh) + countNodes(root.left);
        return (1 << lh) + countNodes(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}
