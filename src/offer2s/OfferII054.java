package offer2s;

import util.TreeNode;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII054
 * @since 2023/5/3 11:42
 */
public class OfferII054 {
    public static void main(String[] args) {
        OfferII054 offerII054 = new OfferII054();
        System.out.println(offerII054.convertBST(TreeNode.createBinaryTree(Arrays.asList(1, 2, 3))));
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val = (sum += root.val);
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        TreeNode right = convertBST2(root.right), curr = right;
        while (curr != null && curr.left != null) curr = curr.left;
        root.val += curr == null ? 0 : curr.val;
        curr = root.left;
        while (curr != null && curr.right != null) curr = curr.right;
        if (curr != null) curr.val += root.val;
        convertBST2(root.left);
        return root;
    }
}
