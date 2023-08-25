package offer2s;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII056
 * @since 2023/5/3 13:36
 */
public class OfferII056 {
    public static void main(String[] args) {

    }

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
