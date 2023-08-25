package problems;

import util.TreeNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2331
 * @since 2023/2/6 10:00
 */
public class Problem2331 {
    public static void main(String[] args) {

    }
    public boolean evaluateTree(TreeNode root) {
        return root.left == null ? root.val == 1 : root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
