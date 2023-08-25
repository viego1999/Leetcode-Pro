package problems;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1110
 * @since 2023/5/30 9:54
 */
public class Problem1110 {
    public static void main(String[] args) {

    }

    List<TreeNode> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) set.add(i);
        if (delete(root) != null) ans.add(root);
        return ans;
    }

    public TreeNode delete(TreeNode node) {
        if (node == null) return null;
        if (set.contains(node.val)) {
            TreeNode l = delete(node.left), r = delete(node.right);
            if (l != null) ans.add(l);
            if (r != null) ans.add(r);
            return null;
        } else {
            node.left = delete(node.left);
            node.right = delete(node.right);
            return node;
        }
    }
}
