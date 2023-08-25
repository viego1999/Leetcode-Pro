package offer2s;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII044
 * @since 2023/4/30 23:54
 */
public class OfferII044 {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
