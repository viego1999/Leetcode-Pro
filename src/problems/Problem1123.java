package problems;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1123
 * @since 2023/9/6 11:00
 */
public class Problem1123 {
    public static void main(String[] args) {

    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        map.put(null, 0);
        dfs(root);
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        int left = map.get(root.left), right = map.get(root.right);
        if (left == right) return root;
        return left > right ? helper(root.left) : helper(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int height = Math.max(left, right) + 1;
        map.put(root, height);
        return height;
    }
}
