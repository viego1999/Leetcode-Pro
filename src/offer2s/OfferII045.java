package offer2s;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII045
 * @since 2023/5/1 12:21
 */
public class OfferII045 {
    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        int ans = -1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans = queue.peek().val;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return ans;
    }
}
