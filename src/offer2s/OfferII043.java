package offer2s;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII043
 * @since 2023/4/30 21:30
 */
public class OfferII043 {
    public static void main(String[] args) {

    }

    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(v);
     * TreeNode param_2 = obj.get_root();
     */
    static class CBTInserter {
        TreeNode root;
        Queue<TreeNode> queue = new ArrayDeque<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(this.root);
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                if (poll.left == null || poll.right == null) queue.offer(poll);
                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v), peek = queue.peek();
            if (peek.left == null) peek.left = node;
            else {
                peek.right = node;
                queue.poll();
            }
            queue.offer(node);
            return peek.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
